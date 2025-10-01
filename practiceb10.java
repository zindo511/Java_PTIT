import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class practiceb10 {
    static class Student {
        String codeStudent, fullName, lop, email;
        public Student(String codeStudent, String fullName, String lop, String email) {
            this.codeStudent = codeStudent;
            this.fullName = fullName;
            this.lop = lop;
            this.email = email;
        }

        public String getCodeStudent() {
            return codeStudent;
        }

        public String toString() {
            return codeStudent + " " + fullName + " " + lop + " " + email;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            String codeStudent = scanner.nextLine(), fullName = trans(scanner.nextLine()), lop = scanner.nextLine(), email = scanner.nextLine();
            students.add(new Student(codeStudent, fullName, lop, email));
        }
        students.sort(
                Comparator.comparing(Student::getCodeStudent)
        );
        students.forEach(System.out::println);
        scanner.close();
    }

    static String trans(String s) {
        s = s.toLowerCase().trim();
        String[] parts = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; ++i)
            sb.append(parts[i].substring(0, 1).toUpperCase()).append(parts[i].substring(1)).append(" ");
        return sb.toString().trim();
    }
}
