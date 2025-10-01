import java.util.*;

public class J06006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, InforCustomer> map1 = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            String customerCode = "KH" + String.format("%03d", i),
                    customerName = scanner.nextLine(),
                    customerSex = scanner.nextLine(),
                    customerBirth = scanner.nextLine(),
                    customerAdd = scanner.nextLine();
            map1.put(customerCode, new InforCustomer(customerName, customerAdd));
        }

        int m = scanner.nextInt();
        Map<String, Good> map2 = new HashMap<>();
        for (int i = 1; i <= m; ++i) {
            scanner.nextLine();
            String goodCode = "MH" + String.format("%03d", i),
                    goodName = scanner.nextLine(),
                    unit = scanner.nextLine();
            long buy = scanner.nextLong(), sell = scanner.nextLong();
            map2.put(goodCode, new Good(goodName, buy, sell));
        }

        int k = scanner.nextInt();
        ArrayList<Bill> bills = new ArrayList<>();
        for (int i = 1; i <= k; ++i) {
            scanner.nextLine();
            String billCode = "HD" + String.format("%03d", i),
                    customerCode = scanner.next(),
                    goodCode = scanner.next();
            long num = scanner.nextLong();

            InforCustomer inforCustomer = map1.get(customerCode);
            Good good = map2.get(goodCode);

            bills.add(new Bill(billCode, inforCustomer.customerName, inforCustomer.customerAdd, good.goodName, num, good.sell * num, (good.sell - good.buy) * num));
        }

        bills.sort(
                Comparator.comparing(Bill::getProfit, Comparator.reverseOrder())
        );

        bills.forEach(System.out::println);
        scanner.close();
    }

    static class InforCustomer {
        private String customerName, customerAdd;
        public InforCustomer(String customerName, String customerAdd) {
            this.customerName = customerName;
            this.customerAdd = customerAdd;
        }
    }

    static class Good {
        private String goodName;
        private long buy, sell;
        public Good(String goodName, long buy, long sell) {
            this.goodName = goodName;
            this.buy = buy;
            this.sell = sell;
        }
    }

    static class Bill {
        private String billCode, customerName, customerAdd, goodName;
        private long num, total, profit;

        public Bill(String billCode, String customerName, String customerAdd, String goodName, long num, long total, long profit) {
            this.billCode = billCode;
            this.customerName = customerName;
            this.customerAdd = customerAdd;
            this.goodName = goodName;
            this.num = num;
            this.total = total;
            this.profit = profit;
        }

        public long getProfit() {
            return profit;
        }

        public String toString() {
            return billCode + " " + customerName + " " + customerAdd + " " + goodName + " " + num + " " +
                    total + " " + profit;
        }
    }
}
