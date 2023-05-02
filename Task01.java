import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Task01 {
    public static void main(String[] args) {
        Base nb1 = new Base("Asus", "15 D543MA-DM1368", 4, 1024, "Win10", "black");
        Base nb2 = new Base("Acer", "Aspire 3 A315-23-R0HR", 4, 256, "Win10", "black");
        Base nb3 = new Base("Lenovo", "IdeaPad 3 15IML05", 8, 1024, "Win11", "gray");
        Base nb4 = new Base("MSI", "Modern 15 B11-002RU", 8, 256, "Win11", "black");
        Base nb5 = new Base("Asus", "VivoBook Pro 14 K3400PA-KP109", 16, 512, "Win10", "silver");
        Base nb6 = new Base("MSI", "Summit E13 Flip Evo A12MT-061RU", 16, 512, "Без ОС", "gray");
        Base nb7 = new Base("Huawei", "MateBook D16 RLEF-X", 16, 512, "Win10", "gray");
        Base nb8 = new Base("Asus", "ROG Zephyrus G14 GA402RJ-L4045", 8, 1024, "Без ОС", "silver");
        Base nb9 = new Base("MSI", "Raider GE78 HX 13VH-094RU", 32, 2048, "Win11", "black");
        Base nb10 = new Base("Apple", "MacBook Air", 8, 256, "MacOS", "black");

        HashSet<Base> notebooks = new HashSet<>(Arrays.asList(nb1, nb2, nb3, nb4, nb5, nb6, nb7, nb8, nb9, nb10));

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Выберите параметр ноутбука\n");
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    1.Выбор по ОЗУ
                    2.Выбор по жесткому диску
                    3.Выбор по ОС
                    4.Выбор по цвету
                    5.Все модели
                    6.Выход""");

            String operation = sc.nextLine();
            switch (operation) {
                case "1" -> filterRAM(notebooks, sc);
                case "2" -> FilterHardDisk(notebooks, sc);
                case "3" -> filterOS(notebooks, sc);
                case "4" -> filterColor(notebooks, sc);
                case "5" -> showCatalog(notebooks);
                case "6" -> {
                    System.out.println("База закрыта");
                    flag = false;
                }
                default -> {
                    System.out.println("Введена неправильная операция");
                    System.out.println();
                }
            }
        }

    }

    public static void filterRAM(HashSet<Base> notebooks, Scanner scanner) {
        TreeSet<Integer> ram = new TreeSet<>();
        for (Base note : notebooks) {
            ram.add(note.getRam());
        }
        System.out.println();
        System.out.println("Возможные варианты ОЗУ "
                + ram + " Гб\n" +
                "Введите интересующее значение: ");

        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (ram.contains(filter)) {
            System.out.println();
            System.out.println("Подходящие ноутбуки: ");
            System.out.println();
            for (Base note : notebooks) {
                if (note.getRam() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Неправильное значение. Попробуйте снова");
            filterRAM(notebooks, scanner);
        }

    }

    public static void FilterHardDisk(HashSet<Base> notebooks, Scanner scanner) {
        TreeSet<Integer> hardDisk = new TreeSet<>();
        for (Base note : notebooks) {
            hardDisk.add(note.getHardDisk());
        }
        System.out.println();
        System.out.println("Возможные размеры жесткого диска: "
                + hardDisk + " Гб\n" +
                "Введите интересующее значение: ");

        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (hardDisk.contains(filter)) {
            System.out.println();
            System.out.println("Подходящие ноутбуки: ");
            System.out.println();
            for (Base note : notebooks) {
                if (note.getHardDisk() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Неправильное значение. Попробуйте снова");
            FilterHardDisk(notebooks, scanner);
        }
    }

    public static void filterOS(HashSet<Base> notebooks, Scanner scanner) {
        TreeSet<String> operSystems = new TreeSet<>();
        for (Base note : notebooks) {
            operSystems.add(note.getOpSystem());
        }
        System.out.println();
        System.out.println("Возможные операционные системы: "
                + operSystems + "\n" +
                "Введите интересующее значение: ");

        String oper = scanner.nextLine().toLowerCase();
        if (operSystems.contains(oper)) {
            System.out.println();
            System.out.println("Подходящие ноутбуки: ");
            System.out.println();
            for (Base note : notebooks) {
                if (note.getOpSystem().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такой ОС. Попробуйте снова");
            filterOS(notebooks, scanner);

        }
    }

    public static void filterColor(HashSet<Base> notebooks, Scanner scanner) {
        TreeSet<String> colors = new TreeSet<>();
        for (Base note : notebooks) {
            colors.add(note.getColor());
        }
        System.out.println();
        System.out.println("Возможные цвета:  "
                + colors + "\n" +
                "Введите интересующий цвет: ");

        String oper = scanner.nextLine().toLowerCase();
        if (colors.contains(oper)) {
            System.out.println();
            System.out.println("Подходящие ноутбуки: ");
            System.out.println();
            for (Base note : notebooks) {
                if (note.getColor().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такого цвета. Попробуйте снова");
            filterColor(notebooks, scanner);
        }
    }

    public static void showCatalog(HashSet<Base> notebooks) {
        System.out.println();
        System.out.println("Все модели ноутбуков: ");
        System.out.println();
        for (Base note : notebooks) {
            note.showInfo();
        }
    }
}
