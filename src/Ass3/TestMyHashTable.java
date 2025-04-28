package Ass3;

public class TestMyHashTable {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        MyTestingClass key1 = new MyTestingClass("Alice");
        MyTestingClass key2 = new MyTestingClass("Bob");
        MyTestingClass key3 = new MyTestingClass("Charlie");

        // Добавляем пары ключ-значение
        table.put(key1, "Student1");
        table.put(key2, "Student2");
        table.put(key3, "Student3");

        //Выводим всю таблицу
        System.out.println(table.get(key1));
        System.out.println(table.get(key2));
        System.out.println(table.get(key3));

        System.out.println("Размер таблицы: " + table.size()); // Должно быть 3

        // Проверяем метод get
        System.out.println("Значение для ключа Alice: " + table.get(key1)); // Student1

        // Проверяем метод contains
        System.out.println("Содержит значение Student2? " + table.contains("Student2")); // true

        // Проверяем метод getKey
        System.out.println("Ключ для значения Student3: " + table.getKey("Student3").getName()); // Charlie

        // Удаляем элемент
        table.remove(key2);
        System.out.println("Размер после удаления: " + table.size()); // Должно быть 2
        System.out.println("Значение для ключа Bob после удаления: " + table.get(key2)); // null
    }
}