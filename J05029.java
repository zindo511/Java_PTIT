import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05029 {
    static class Company {
        private String ma, ten;
        private int num;

        public Company(String ma, String ten, int num) {
            this.ma = ma;
            this.ten = ten;
            this.num = num;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Company> companies = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine();
            int num = scanner.nextInt();
            companies.add(new Company(ma, ten, num));
        }

        companies.sort(
                Comparator.comparing((Company company) -> company.num, Comparator.reverseOrder())
                        .thenComparing((Company company) -> company.ma)
        );
        int q = scanner.nextInt();
        while (q-- > 0) {
            int a = scanner.nextInt(),
                    b = scanner.nextInt();
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU " + a + " DEN " + b + " SINH VIEN:");
            for (int i = 0; i < companies.size(); ++i){
                Company company = companies.get(i);
                if (company.num >= a && company.num <= b) {
                    System.out.println(company.ma + " " + company.ten + " " + company.num);
                }
            }
        }
        scanner.close();
    }
}
