import java.io.File;
import java.util.*;

public class J07019 {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(new File("DATA1.in"));
        Map<String, Bill> map = new HashMap<>();
        int n = scanner1.nextInt();
        for (int i = 1; i <= n; ++i) {
            scanner1.nextLine();
            String code = scanner1.nextLine(),
                    name = scanner1.nextLine();
            long price1 = scanner1.nextLong(),
                    price2 = scanner1.nextLong();
            map.put(code, new Bill(name, price1, price2));
        }

        Scanner scanner2 = new Scanner(new File("DATA2.in"));
        int m = scanner2.nextInt();
        for (int i = 1; i <= m; ++i) {
            scanner2.nextLine();
            String billCode = scanner2.next();
            int quantity = scanner2.nextInt();
            String addCode = "-" + String.format("%03d", i);
            Bill bill = map.get(billCode.substring(0, 2));

            long price = billCode.substring(2).equals("1") ? bill.price1 : bill.price2;
            long total = quantity * price, discount = 0;

            if (quantity >= 150) discount = total * 50 / 100;
            else if (quantity >= 100) discount = total * 30 / 100;
            else if (quantity >= 50) discount = total * 15 / 100;

            System.out.println(billCode + addCode + " " + bill.name + " " + discount + " " + (total - discount));
        }
        scanner1.close();
        scanner2.close();
    }

    static class Bill{
        String name;
        long price1, price2;

        public Bill(String name, long price1, long price2) {
            this.name = name;
            this.price1 = price1;
            this.price2 = price2;
        }
    }
}
