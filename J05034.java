import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05034 {
    static class Student {
        private String msv, ten, lop, email, dn;
        private int stt;

        public Student(int stt, String msv, String ten, String lop, String email, String dn) {
            this.stt = stt;
            this.msv = msv;
            this.ten = ten;
            this.lop = lop;
            this.email = email;
            this.dn = dn;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            String msv = scanner.nextLine(),
                    ten = scanner.nextLine(),
                    lop = scanner.nextLine(),
                    email = scanner.nextLine(),
                    dn = scanner.nextLine();
            students.add(new Student(i, msv, ten, lop, email, dn));
        }

        students.sort(
                Comparator.comparing((Student student) -> student.ten)
        );

        int q = scanner.nextInt();
        scanner.nextLine();
        while (q-- > 0) {
            String s = scanner.nextLine();
            for (int i = 0; i < students.size(); ++i) {
                Student student = students.get(i);
                if (student.dn.equals(s))
                    System.out.println(student.stt + " " + student.msv + " " + student.ten + " "
                            + student.lop + " " + student.email + " " + student.dn);
            }
        }
        scanner.close();
    }
}
