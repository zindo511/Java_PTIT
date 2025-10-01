import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07037 {
    static class Company {
        private String ma, ten;
        private int soSinhVien;

        public Company(String ma, String ten, int soSinhVien) {
            this.ma = ma;
            this.ten = ten;
            this.soSinhVien = soSinhVien;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + soSinhVien;
        }
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("DN.in"));
            int n = scanner.nextInt();

            ArrayList<Company> companies = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                scanner.nextLine();
                String ma = scanner.nextLine(),
                        ten = scanner.nextLine();
                int soSinhVien = scanner.nextInt();
                companies.add(new Company(ma, ten, soSinhVien));
            }
            companies.sort(
                    Comparator.comparing((Company company) -> company.ma)
            );
            companies.forEach(System.out:: println);
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
