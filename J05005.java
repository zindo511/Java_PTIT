import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05005 {
    static String trans(String s) {
        String[] parts = s.split("/");
        if (parts[0].length() == 1) parts[0] = "0" + parts[0];
        if (parts[1].length() == 1) parts[1] = "0" + parts[1];
        return parts[0] + "/" + parts[1] + "/" + parts[2];
    }

    static String name(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i) {
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1).toLowerCase() + " ");
        }
        return res.toString().trim();
    }

    static class Student {
        private String ma, ten, lop, ns;
        private double gpa;

        public Student(String ma, String ten, String lop, String ns, double gpa) {
            this.ma = ma;
            this.ten = ten;
            this.lop = lop;
            this.ns = ns;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return ma + " " + name(ten) + " " + lop + " " + trans(ns) + " " + String.format("%.2f", gpa);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String ten = scanner.nextLine(),
                    lop = scanner.nextLine(),
                    ns = scanner.nextLine();
            double gpa = scanner.nextDouble();

            String ma = "B20DCCN" + String.format("%03d", i);
            students.add(new Student(ma, ten, lop, ns, gpa));
        }

        students.sort(
                Comparator.comparing((Student student) -> student.gpa, Comparator.reverseOrder())
        );

        students.forEach(System.out::println);
        scanner.close();
    }
}
