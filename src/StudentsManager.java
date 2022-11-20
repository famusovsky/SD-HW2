import java.util.ArrayList;
import java.util.Scanner;

public class StudentsManager {
    private final ArrayList<Student> students;

    public StudentsManager(Integer numStudents, Scanner scanner) {
        students = new ArrayList<>();
        for (int i = 0; i < numStudents; ++i) {
            System.out.println("Введите имя и фамилию студента:");
            students.add(new Student(i, scanner.next(), scanner.next()));
        }
    }

    public void printStudents() {
        for (var student : students) {
            if (student.isFlagged) {
                System.out.println(student + " - оценка: " + student.getAssignmentScore());
            }
        }
    }

    private void setAssignmentScore(Student student, Scanner scanner) {
        var score = -1;
        while (score < 1 || score > 10) {
            System.out.println("Введите оценку (от 1 до 10) студента " + student.toString());
            score = scanner.nextInt();
        }
        student.setAssignmentScore(score);
    }

    public void pick(Scanner scanner) {
        var id = (int) (Math.random() * students.size());
        while (students.get(id).isFlagged) {
            id = (int) (Math.random() * students.size());
        }
        var student = students.get(id);
        System.out.println("Выбрать студента " + student + "? Y - да, N - нет, Другое - прекратить выбор");
        var input = scanner.next();
        if (input.equals("Y")) {
            System.out.println("Студент " + student + " выбран");
            student.isFlagged = true;
            setAssignmentScore(student, scanner);
            students.set(id, student);
        } else if (input.equals("N")) {
            pick(scanner);
        } else {
            System.out.println("Выбор прекращен");
        }
    }
}
