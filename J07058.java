import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07058 {
    static class Subject {
        private String ma, ten, hinhThucThi;

        public Subject(String ma, String ten, String hinhThucThi) {
            this.ma = ma;
            this.ten = ten;
            this.hinhThucThi = hinhThucThi;
        }

        public String getMa() {
            return ma;
        }
        @Override
        public String toString() {
            return  ma + " " + ten + " " + hinhThucThi;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("MONHOC.in"));
        int n = scanner.nextInt();

        scanner.nextLine();
        ArrayList<Subject> subjects = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine(),
                    hinhThucThi = scanner.nextLine();
            subjects.add(new Subject(ma, ten, hinhThucThi));
        }

        subjects.sort(
                Comparator.comparing(Subject::getMa)
        );

        subjects.forEach(System.out::println);
        scanner.close();
    }
}
