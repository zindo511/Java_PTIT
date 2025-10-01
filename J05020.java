import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05020 {
    static class Student {
        private String msv, name, lop, email;

        public Student(String msv, String name, String lop, String email) {
            this.msv = msv;
            this.name = name;
            this.lop = lop;
            this.email = email;
        }
        @Override
        public String toString() {
            return msv + " " + name + " " + lop + " " + email;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Student> students = new ArrayList<>();
        while (t-- > 0) {
            String msv = scanner.nextLine(),
                    name = scanner.nextLine(),
                    lop = scanner.nextLine(),
                    email = scanner.nextLine();
            students.add(new Student(msv, name, lop, email));
        }

        students.sort(
                Comparator.comparing((Student s) -> s.lop)
                        .thenComparing((Student s) -> s.msv)
        );
        students.forEach(System.out::println);
        scanner.close();
    }
}
//Thông tin về mỗi sinh viên gồm:
//
//Mã sinh viên: dãy ký tự không có khoảng trống (không quá 15). Đảm bảo không trùng nhau.
//Họ và tên: độ dài không quá 100
//Lớp: dãy ký tự không có khoảng trống (không quá 15)
//Email: dãy ký tự không có khoảng trống (không quá 15)