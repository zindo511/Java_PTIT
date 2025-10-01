import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05021 {
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine(),
                    lop = scanner.nextLine(),
                    email = scanner.nextLine();
            students.add(new Student(ma, ten, lop, email));
        }

        students.sort(
                Comparator.comparing((Student student) -> student.ma)
        );
        students.forEach(System.out::println);
        scanner.close();
    }
}

