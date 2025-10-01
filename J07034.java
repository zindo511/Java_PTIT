import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07034 {
    static class Subject {
        private String ma, ten, tinChi;

        public Subject(String ma, String ten, String tinChi) {
            this.ma = ma;
            this.ten = ten;
            this.tinChi = tinChi;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + tinChi;
        }
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("MONHOC.in"));
            int n = scanner.nextInt();
            scanner.nextLine();

            ArrayList<Subject> subjects = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                String ma = scanner.nextLine(),
                        ten = scanner.nextLine(),
                        tinChi = scanner.nextLine();
                subjects.add(new Subject(ma, ten, tinChi));
            }

            subjects.sort(
                    Comparator.comparing((Subject subject) -> subject.ten)
            );

            subjects.forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
