import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class J07033 {
    static class Student {
        private String ma, ten, lop, email;

        public Student(String ma, String ten, String lop, String email) {
            this.ma = ma;
            this.ten = ten;
            this.lop = lop;
            this.email = email;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + lop + " " + email;
        }
    }
    static String trans(String s) {
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0;  i < parts.length; ++i) {
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1) + " ");
        }
        return res.toString();
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("SINHVIEN.in"));

            ArrayList<Student> students = new ArrayList<>();
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= n; ++i) {
                String ma = scanner.nextLine(),
                        ten = scanner.nextLine(),
                        lop = scanner.nextLine(),
                        email = scanner.nextLine();
                students.add(new Student(ma, trans(ten), lop, email));
            }
            students.sort(
                    Comparator.comparing((Student student) -> student.ma)
            );
            students.forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
