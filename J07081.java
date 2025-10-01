import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07081 {
    static class Student {
        private String studentID, fullName, sdt, email;
        public Student(String studentID, String fullName, String sdt, String email) {
            this.studentID = studentID;
            this.fullName = fullName;
            this.sdt = sdt;
            this.email = email;
        }

        @Override
        public String toString() {
            return studentID + " " + fullName + " " + sdt + " " + email;
        }
    }
    static String getTen(String s) {
        String[] parts = s.split("\\s+");
        return parts[parts.length - 1];
    }

    static String getHo(String s) {
        String[] parts = s.split("\\s+");
        return parts[0];
    }

    static String getDem(String s) {
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < parts.length - 1; ++i) {
            res.append(parts[i] + " ");
        }
        return res.toString().trim();
    }
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(new File("SINHVIEN.in"));
            int n = Integer.parseInt(scanner.nextLine());
            ArrayList<Student> students = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                String studentID = scanner.nextLine(),
                        fullName = scanner.nextLine(),
                        sdt = scanner.nextLine(),
                        email = scanner.nextLine();
                students.add(new Student(studentID, fullName, sdt, email));
            }
            students.sort(
                    Comparator.comparing((Student student) -> getTen(student.fullName))
                            .thenComparing((Student student) -> getHo(student.fullName))
                            .thenComparing((Student student) -> getDem(student.fullName))
                            .thenComparing((Student student) -> student.studentID)
            );
            students.forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
