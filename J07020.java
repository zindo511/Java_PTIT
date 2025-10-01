import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J07020 {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(new File("KH.in"));
        int n = Integer.parseInt(scanner1.nextLine());
        Map<String, Customer> map1 = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            String codeCustomer = "KH" + String.format("%03d", i),
                    nameCustomer = scanner1.nextLine(),
                    gender = scanner1.nextLine(),
                    birth = scanner1.nextLine(),
                    address = scanner1.nextLine();
            map1.put(codeCustomer, new Customer(nameCustomer, address));
        }

        Scanner scanner2 = new Scanner(new File("MH.in"));
        Map<String, Good> map2 = new HashMap<>();
        int m = scanner2.nextInt();
        for (int i = 1; i <= m; ++i) {
            scanner2.nextLine();
            String codeGood = "MH" + String.format("%03d", i),
                    nameGood = scanner2.nextLine(),
                    unit = scanner2.nextLine();
            long buy = scanner2.nextLong(),
                    sell = scanner2.nextLong();
            map2.put(codeGood, new Good(nameGood, unit, buy, sell));
        }

        Scanner scanner3 = new Scanner(new File("HD.in"));
        int k = scanner3.nextInt();
        for (int i = 1; i <= k; ++i) {
            scanner3.nextLine();
            String codeBill = "HD" + String.format("%03d", i),
                    codeCustomer = scanner3.next(), codeGood = scanner3.next();
            long quantity = scanner3.nextInt();
            Customer customer = map1.get(codeCustomer);
            Good good = map2.get(codeGood);
            System.out.println(codeBill + " " + customer.nameCustomer + " " + customer.address + " " +
                    good.nameGood + " " + good.unit + " " + good.buy + " " + good.sell + " " + quantity + " " + good.sell * quantity);
        }
        scanner1.close();
        scanner2.close();
        scanner3.close();
    }

    static class Customer {
        String nameCustomer, address;

        public Customer(String nameCustomer, String address) {
            this.nameCustomer = nameCustomer;
            this.address = address;
        }
    }

    static class Good {
        String nameGood, unit;
        long buy, sell;

        public Good(String nameGood, String unit, long buy, long sell) {
            this.nameGood = nameGood;
            this.unit = unit;
            this.buy = buy;
            this.sell = sell;
        }
    }
}