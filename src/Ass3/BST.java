package Ass3;

import java.util.*;

// Класс BST теперь реализует Iterable<Node>
public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {
    private Node root;
    private int size;

    public class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }

    public int size() {
        return size;
    }

    public void put(K key, V val) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        if (root == null) {
            root = new Node(key, val);
            size++;
            return;
        }

        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                current.val = val;
                return;
            } else if (cmp < 0) {
                if (current.left == null) {
                    current.left = new Node(key, val);
                    size++;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(key, val);
                    size++;
                    return;
                }
                current = current.right;
            }
        }
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                return current.val;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        if (root == null) {
            return;
        }

        Node parent = null;
        Node current = root;
        boolean isLeftChild = false;

        while (current != null && key.compareTo(current.key) != 0) {
            parent = current;
            if (key.compareTo(current.key) < 0) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            return;
        }

        size--;

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            Node successorParent = current;
            Node successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.key = successor.key;
            current.val = successor.val;

            if (successorParent == current) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
        }
    }

    // Реализация метода iterator() из интерфейса Iterable<Node>
    @Override
    public Iterator<Node> iterator() {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Node> {
        private Stack<Node> stack = new Stack<>();
        private Node current;

        public InOrderIterator() {
            current = root;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Node node = stack.pop();
            current = node.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            return node;
        }
    }
}