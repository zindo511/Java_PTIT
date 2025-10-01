import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07056 {
    static String trans(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i)
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1) + " ");
        return res.toString().trim();
    }

    static int standard(String s) {
        if (s.equals("A")) return 100;
        if (s.equals("B")) return 500;
        return 200;
    }

    static class calPower {
        private String customerID, fullName;
        private int moneyInStandard, moneyOverStandard, total, VAT;

        public calPower(String customerID, String fullName, int moneyInStandard, int moneyOverStandard, int VAT, int total) {
            this.customerID = customerID;
            this.fullName = fullName;
            this.moneyInStandard = moneyInStandard;
            this.moneyOverStandard = moneyOverStandard;
            this.total = total;
            this.VAT = VAT;
        }

        @Override
        public String toString() {
            return customerID + " " + fullName + " " + moneyInStandard + " " + moneyOverStandard + " " + VAT + " " + total;
        }
    }
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(new File("KHACHHANG.in"));
            int n = scanner.nextInt();
            ArrayList<calPower> calPowers = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                scanner.nextLine();
                String customerID = "KH" + String.format("%02d", i);
                String fullName = trans(scanner.nextLine());
                String type = scanner.next();
                int begin = scanner.nextInt(),
                        end = scanner.nextInt();

                int numPower = end - begin, moneyInStandard, moneyOverStandard, VAT, total;
                if (numPower < standard(type)) moneyInStandard = numPower * 450;
                else moneyInStandard = standard(type) * 450;

                if (numPower > standard(type)) moneyOverStandard = (numPower - standard(type)) * 1000;
                else moneyOverStandard = 0;

                VAT = moneyOverStandard * 5 / 100;
                total = moneyInStandard + moneyOverStandard + VAT;
                calPowers.add(new calPower(customerID, fullName, moneyInStandard, moneyOverStandard, VAT, total));
            }
            calPowers.sort(
                    Comparator.comparing((calPower calpower) -> calpower.total, Comparator.reverseOrder())
            );
            calPowers.forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
