import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05012 {
    static class Calculate {
        private String goodCode, goodName;
        private long buyNum, price, discount, total;

        public Calculate(String goodCode, String goodName, long buyNum, long price, long discount, long total) {
            this.goodCode = goodCode;
            this.goodName = goodName;
            this.buyNum = buyNum;
            this.price = price;
            this.discount = discount;
            this.total = total;
        }
        public long getTotal() {
            return total;
        }
        public String toString() {
            return goodCode + " " + goodName + " " + buyNum + " " + price + " " + discount + " " + total;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Calculate> calculates = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String goodCode = scanner.nextLine(),
                    goodName = scanner.nextLine();
            long buyNum = scanner.nextLong(),
                    price = scanner.nextLong(),
                    discount = scanner.nextLong();
            long total = price * buyNum - discount;
            calculates.add(new Calculate(goodCode, goodName, buyNum, price, discount, total));
        }
        calculates.sort(
                Comparator.comparing(Calculate::getTotal, Comparator.reverseOrder())
        );
        calculates.forEach(System.out::println);
        scanner.close();
    }
}
