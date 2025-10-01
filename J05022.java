import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05022 {
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

        int q = scanner.nextInt();
        scanner.nextLine();
        while (q-- > 0) {
            String s = scanner.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + s + ":");
            for (int i = 0; i < students.size(); ++i){
                Student hs = students.get(i);
                if (hs.lop.equals(s)) System.out.println(hs.msv + " " + hs.name + " " + hs.lop + " " + hs.email);
            }
        }
        scanner.close();
    }
}
