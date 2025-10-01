import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05028 {
    static class Company {
        private String ma, ten;
        private int num;

        public Company(String ma, String ten, int num) {
            this.ma = ma;
            this.ten = ten;
            this.num = num;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + num;
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
        companies.forEach(System.out::println);
        scanner.close();
    }
}
