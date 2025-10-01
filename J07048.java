import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07048 {
    static class Good {
        private String ma, ten;
        private int gia, time;

        public Good (String ma, String ten, int gia, int time) {
            this.ma = ma;
            this.ten = ten;
            this.gia = gia;
            this.time = time;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + gia + " " + time;
        }
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("SANPHAM.in"));
            int n = scanner.nextInt();

            ArrayList<Good> goods = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                scanner.nextLine();
                String ma = scanner.nextLine(),
                        ten = scanner.nextLine();
                int gia = scanner.nextInt(),
                        time = scanner.nextInt();
                goods.add(new Good(ma, ten, gia, time));
            }

            goods.sort(
                    Comparator.comparing((Good good) -> good.gia, Comparator.reverseOrder())
                            .thenComparing((Good good) -> good.ma)
            );

            goods.forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
