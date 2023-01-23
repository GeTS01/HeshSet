import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static HashSetImpl<String, Integer> hashSet = new HashSetImpl();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        try {
            System.out.println("Выберите действие\n" +
                    "1) Посмотреть колличество элементов \n" +
                    "2) Проверить содержит ли список элемент (true - не содержит)\n" +
                    "3) Проверить наличие элемента\n" +
                    "4) Перебрать весь список\n" +
                    "5) Добавить элемент\n" +
                    "6) Удалить элемент\n" +
                    "7) Проверить наличие коллекции в списке\n" +
                    "8) Добавить колллекцию в список\n" +
                    "9) Удалить список\n" +
                    "10)Удалить весь список" +
                    "11)Переделать в массив");
            System.out.println();
            System.out.println("Выберите действие");
            int number = scanner.nextInt();
            if (number == 1) {
                System.out.println(hashSet.size());
            } else if (number == 2) {
                System.out.println(hashSet.isEmpty());
            } else if (number == 3) {
                containsElement();
            } else if (number == 4) {
                for (String s : hashSet) {
                    System.out.println(s);
                }
            } else if (number == 5) {
                putElement();
            } else if (number == 6) {
                removeElement();
            } else if (number == 7) {
                containsAllElements();
            } else if (number == 8) {
                putAllElements();
            } else if (number == 9) {
                removeAll();
            } else if (number == 10) {
                hashSet.clear();
            } else if (number == 11) {
                System.out.println(Arrays.toString(hashSet.toArray()));
            } else {
                System.out.println("Такого варианта нет");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            menu();
        }
    }

    public static void containsElement() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите Имя");
        String title = scanner1.nextLine();
        People people = new People(title);
        System.out.println(hashSet.contains(people));
    }

    public static void putElement() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите Имя");
        String title = scanner1.nextLine();
        String people = String.valueOf(new People(title));
        System.out.println(hashSet.add(people));
    }

    public static void removeElement() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите значение");
        String title = scanner1.nextLine();
        System.out.println(hashSet.remove(title));
    }

    public static void containsAllElements() {
        HashSet<String> map = new HashSet<>();
        map.add("Иван");
        map.add("Георгий");
        System.out.println(hashSet.containsAll(map));
    }

    public static void putAllElements() {
        HashSet<String> map = new HashSet<>();
        map.add("Иван");
        map.add("Георгий");
        System.out.println(hashSet.addAll(map));
    }

    public static void removeAll() {
        Scanner scanner1 = new Scanner(System.in);
        HashSet<String> map = new HashSet<>();
        map.add("Иван");
        map.add("Георгий");
        System.out.println("Выберите вариант удаления: \n" +
                "Удалить все элементы кроме пераданной коллекции" +
                "Удалить переданную коллекцию");
        int number = scanner1.nextInt();
        if (number == 1) {
            hashSet.containsAll(map);
        } else if (number == 2) {
            hashSet.removeAll(map);
        } else {
            System.out.println("Такого варианта нет");
        }
    }
}