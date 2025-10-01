import java.util.*;

public class J05017 {
    static class Bill {
        String customerCode, fullName;
        long total;

        public Bill(String customerCode, String fullName, long total) {
            this.customerCode = customerCode;
            this.fullName = fullName;
            this.total = total;
        }
        public long getTotal(){
            return total;
        }
        public String toString(){
            return customerCode + " " + fullName + " " + total;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Bill> bills = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String customerCode = "KH" + String.format("%02d", i);
            String fullName = scanner.nextLine();
            int indexOld = scanner.nextInt(),
                    indexNew = scanner.nextInt();
            int index = indexNew - indexOld;

            long total;
            if (index <= 50) {
                total = Math.round(index * 100 * 1.02);
            }
            else if (index <= 100) {
                long base =  50 * 100 + (index - 50) * 150;
                total = Math.round(base * 1.03);
            }
            else {
                long base = 50 * 100 + 50 * 150 + (index - 100) * 200L;
                total = Math.round(base * 1.05);
            }
            bills.add(new Bill(customerCode, fullName, total));
        }
        bills.sort(
                Comparator.comparing(Bill::getTotal, Comparator.reverseOrder())
        );
        bills.forEach(System.out::println);
        scanner.close();
    }
}
