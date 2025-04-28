package Ass3;

public class MyHashTable<K, V> {
    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    public MyHashTable() {
        chainArray = (HashNode<K, V>[]) new HashNode[M];
        size = 0;
    }

    private int hash(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }
        return Math.abs(key.hashCode() % M);
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        int index = hash(key);
        HashNode<K, V> current = chainArray[index];

        if (current == null) {
            chainArray[index] = new HashNode<>(key, value);
            size++;
            return;
        }

        HashNode<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }

        prev.next = new HashNode<>(key, value);
        size++;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        int index = hash(key);
        HashNode<K, V> current = chainArray[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                V value = current.value;
                if (prev == null) {
                    chainArray[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (value == null && current.value == null) {
                    return true;
                }
                if (value != null && value.equals(current.value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (value == null && current.value == null) {
                    return current.key;
                }
                if (value != null && value.equals(current.value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }
}