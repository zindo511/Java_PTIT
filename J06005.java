import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J06005 {
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
            map2.put(goodCode, new Good(goodName, unit, buy, sell));
        }

        int k = scanner.nextInt();
        for (int i = 1; i <= k; ++i) {
            scanner.nextLine();
            String billCode = "HD" + String.format("%03d", i),
                    customerCode = scanner.next(),
                    goodCode = scanner.next();
            long num = scanner.nextLong();

            InforCustomer inforCustomer = map1.get(customerCode);
            Good good = map2.get(goodCode);

            System.out.println(billCode + " " + inforCustomer.customerName + " " + inforCustomer.customerAdd + " " +
                    good.goodName + " " + good.unit + " " + good.buy + " " + good.sell + " " + num + " " + good.sell * num);
        }
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
        private String goodName, unit;
        private long buy, sell;
        public Good(String goodName, String unit, long buy, long sell) {
            this.goodName = goodName;
            this.unit = unit;
            this.buy = buy;
            this.sell = sell;
        }
    }
}
