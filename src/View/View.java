package View;

import Model.Group;
import Model.Student;
import Model.Subject;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class View {

    private static final Scanner sc = new Scanner(System.in);

    public int printMenuAndReadCommand() {
        System.out.println("1 - добавить группу");
        System.out.println("2 - добавить студента");
        System.out.println("3 - добавить предмет");
        System.out.println("4 - распечатать все");
        System.out.println("5 - найти все предметы по группе и студенту");
        System.out.println("6 - найти группу по студенту");
        System.out.println("7 - найти группы по предмету");
        System.out.println("8 - найти оценки по группе");
        System.out.println("9 - обновить оценку");
        System.out.println("10 - удалить группу");
        System.out.println("11 - выйти");
        System.out.println("Введите команду: ");
        return sc.nextInt();
    }

    public String readGroupName() {
        System.out.println("Введите название группы");
        return sc.next();
    }

    public String readStudentName() {
        System.out.println("Введите имя студента");
        return sc.next();
    }

    public String readSubjectName() {
        System.out.println("Введите название предмета");
        return sc.next();
    }

    public int readMark() {
        System.out.println("Введите оценку");
        return sc.nextInt();
    }

    public void printBooleanResult(boolean result) {
        if (result) {
            System.out.println("Команда выполнена успешно");
        } else {
            System.out.println("Что-то пошло не так...");
        }
    }

    public void printSubject(Set<Subject> subjects) {
        System.out.println("Subjects list is:");
        System.out.println(subjects);
    }

    public void printGroup(Group group) {
        System.out.println("Group is: ");
        System.out.println(group);
    }

    public void printGroups(Set<Group> groups) {
        System.out.println("Groups list is:");
        System.out.println(groups);
    }

    public void printStudentMarks(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println("Student name: " + student.getStudentName());
            for (Map.Entry<Subject, Integer> entry : student.getSubjectMarkMap().entrySet()) {
                System.out.println(" " + entry.getKey().getName() + ", mark : " + entry.getValue());
            }
        }
    }

    public void printAll(List<Group> groups) {
        System.out.println("Current system data: ");
        System.out.println(groups);
    }

    public void printUnknownCommand() {
        System.out.println("Unknown command!");
    }


}
