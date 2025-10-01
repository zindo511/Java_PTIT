import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05081 {
    static class Good {
        private String ma, name, dvi;
        private int mua, ban;

        public Good(String ma, String name, String dvi, int mua, int ban) {
            this.ma = ma;
            this.name = name;
            this.dvi = dvi;
            this.mua = mua;
            this.ban = ban;
        }

        @Override
        public String toString() {
            return "MH" + ma + " " + name + " " + dvi + " " + mua + " " + ban + " " + (ban - mua);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Good> goods = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String name = scanner.nextLine(),
                    dvi = scanner.nextLine();
            int mua = scanner.nextInt(),
                    ban = scanner.nextInt();
            String ma = String.valueOf(i);
            while (ma.length() < 3) ma = "0" + ma;

            goods.add(new Good(ma, name, dvi, mua, ban));
        }

        goods.sort(
                Comparator.comparing((Good good) -> (good.ban - good.mua), Comparator.reverseOrder())
                        .thenComparing((Good good) -> good.ma)
        );

        goods.forEach(System.out::println);
        scanner.close();
    }
}
