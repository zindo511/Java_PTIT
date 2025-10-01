import java.util.*;

public class J06002 {
    static class Bill {
        private String name;
        private long type1, type2;

        public Bill(String name, long type1, long type2) {
            this.name = name;
            this.type1 = type1;
            this.type2 = type2;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Bill> map = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String code = scanner.nextLine(),
                    name = scanner.nextLine();
            long type1 = scanner.nextLong(),
                    type2 = scanner.nextLong();
            map.put(code, new Bill(name, type1, type2));
        }
        int m = scanner.nextInt();
        ArrayList<BillSort> billSorts = new ArrayList<>();
        for (int i = 1; i <= m; ++i) {
            String code = scanner.next();
            long num = scanner.nextLong();
            String code1 = code.substring(0, 2), type = code.substring(2);
            Bill bill = map.get(code1);
            String stt = String.format("%03d", i);

            long total, discount = 0;
            if (type.equals("1")) {
                total = bill.type1 * num;
            }
            else total = bill.type2 * num;

            if (num >= 150) discount = total * 50 / 100;
            else if (num >= 100) discount = total * 30 / 100;
            else if (num >= 50) discount = total * 15 / 100;

            billSorts.add(new BillSort(code, stt, bill.name, discount, (total - discount)));
        }
        billSorts.sort(
                Comparator.comparing(BillSort::getTotal, Comparator.reverseOrder())
        );
        billSorts.forEach(System.out::println);
        scanner.close();
    }
    static class BillSort {
        private String code, stt, name;
        private long discount, total;

        public BillSort(String code, String stt, String name, long discount, long total) {
            this.code = code;
            this.stt = stt;
            this.name = name;
            this.discount = discount;
            this.total = total;
        }
        public long getTotal() {
            return total;
        }
        public String toString() {
            return code + "-" + stt + " " + name + " " + discount + " " + total;
        }
    }
}
