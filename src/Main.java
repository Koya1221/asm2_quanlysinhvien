import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Main {

    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        // Loop until a valid number of students is entered
        do {
            System.out.println("Enter the number of students:");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("The number of students cannot be 0 or negative. Please enter a valid number.");
            }
        } while (n <= 0);

        scanner.nextLine();  // Consume the newline

        for (int i = 1; i <= n; i++) {
            input(scanner);
        }
        System.out.println("PRINT STUDENT LIST:");
        output();

        System.out.println("Enter the student code you want to delete:");
        String codeToRemove = scanner.nextLine();
        removeByCode(codeToRemove);
        System.out.println("List of students after deletion:");
        output();

        sortByGradeDesc();
        System.out.println("List of students after being sorted by score:");
        output();

        System.out.println("Enter the student code or name you want to find:");
        String keyword = scanner.nextLine();
        Student foundStudent = findByCodeOrName(keyword);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("No students found.");
        }

        System.out.println("Enter the student score you want to search for (>= x):");
        float x = scanner.nextFloat();
        List<Student> filteredStudents = filterByGrade(x);
        System.out.println("List of students with score >= " + x + ":");
        filteredStudents.forEach(System.out::println);

        scanner.close(); // Close the scanner
    }

    // Nhap vao thong tin sinh vien
    public static void input(Scanner scanner) {
        System.out.println("Enter student information:");

        System.out.println("Enter student code:");
        String code = scanner.nextLine();
        System.out.println("Enter student name:");
        String name = scanner.nextLine();
        System.out.println("Enter score:");
        float grade = scanner.nextFloat();
        scanner.nextLine();  // Consume the newline

        Student student = new Student(code, name, grade);
        studentList.add(student);
    }

    // In danh sach sinh vien
    public static void output() {
        studentList.forEach(System.out::println);
    }

    // Xoa sinh vien theo ma
    public static void removeByCode(String code) {
        studentList.removeIf(student -> student.getCode().equals(code));
    }

    // Sap xep sinh vien theo diem giam dan
    public static void sortByGradeDesc() {
        studentList.sort((s1, s2) -> Float.compare(s2.getGrade(), s1.getGrade()));
    }
    // Tim kiem sinh vien theo ma hoac ten
    public static Student findByCodeOrName(String keyword) {
        for (Student student : studentList) {
            if (student.getCode().equals(keyword) || student.getName().equalsIgnoreCase(keyword)) {
                return student;
            }
        }
        return null;
    }

    // Tim kiem sinh vien co diem >= x
    public static List<Student> filterByGrade(float x) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getGrade() >= x) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}

class Student {
    private String code;
    private String name;
    private float grade;

    public Student(String code, String name, float grade) {
        this.code = code;
        this.name = name;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}