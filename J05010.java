import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05010 {
    static class Good {
        private String name, nhom;
        private double buy, sell;
        private int ma;

        public Good(int ma, String name, String nhom, double buy, double sell) {
            this.ma = ma;
            this.name = name;
            this.nhom = nhom;
            this.buy= buy;
            this.sell = sell;
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + nhom + " " + String.format("%.2f", (sell - buy));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String name, nhom;
        double buy, sell;
        int ma;

        ArrayList<Good> goods = new ArrayList<>();
        for (int i = 1; i <= t; ++i){
            scanner.nextLine();
            name = scanner.nextLine();
            nhom = scanner.nextLine();
            buy = scanner.nextDouble();
            sell = scanner.nextDouble();
            goods.add(new Good(i, name, nhom, buy, sell));
        }
        goods.sort(
                Comparator.comparing((Good g) -> (g.sell - g.buy), Comparator.reverseOrder())
        );
        goods.forEach(System.out::println);
        scanner.close();
    }
}
