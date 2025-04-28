package Ass3;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(5, "Пять");
        tree.put(3, "Три");
        tree.put(7, "Семь");
        tree.put(1, "Один");
        tree.put(4, "Четыре");

        System.out.println("Размер дерева: " + tree.size()); // 5

        System.out.println("Значение для ключа 3: " + tree.get(3)); // Три

        for (BST<Integer, String>.Node elem : tree) {
            System.out.println("Ключ: " + elem.getKey() + ", Значение: " + elem.getValue());
        }

        tree.delete(3);
        System.out.println("Размер после удаления: " + tree.size()); // 4
        System.out.println("Значение для ключа 3 после удаления: " + tree.get(3)); // null
    }
}
