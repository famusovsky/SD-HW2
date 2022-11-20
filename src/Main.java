import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество студентов:");
        var scanner = new Scanner(System.in);
        var numStudents = scanner.nextInt();
        var manager = new StudentsManager(numStudents, scanner);
        while (true) {
            System.out.println("/h - помощь");
            var input = scanner.next();
            switch (input) {
                case "/r" -> manager.pick(scanner);
                case "/l" -> manager.printStudents();
                case "/h" -> System.out.println("/r - выбрать случайного студента; " +
                            "/l - вывести список студентов; " + "/e - завершить работу программы");
                case "/e" -> {
                    System.out.println("Программа завершена");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверная команда");
            }
        }
    }
}