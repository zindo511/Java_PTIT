import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class J05082 {
    static String transName(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i){
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1) + " ");
        }
        return res.toString().trim();
    }

    static String transBirthday (String s) {
        s = s.trim();
        String[] parts = s.split("/");
        if (parts[0].length() == 1) parts[0] = "0" + parts[0];
        if (parts[1].length() == 1) parts[1] = "0" + parts[1];
        return parts[0] + "/" + parts[1] + "/" + parts[2];
    }

    static int year(String s) {
        String[] parts = s.split("/");
        return Integer.parseInt(parts[2]);
    }

    static int month(String s) {
        String[] parts = s.split("/");
        return Integer.parseInt(parts[1]);
    }

    static int day(String s) {
        String[] parts = s.split("/");
        return Integer.parseInt(parts[0]);
    }
    static class Customer {
        private String customerCode, customerName, sex, address, birthday;
        public Customer(String customerCode, String customerName, String sex, String address, String birthday) {
            this.customerCode = customerCode;
            this.customerName = customerName;
            this.sex = sex;
            this.address = address;
            this.birthday = birthday;
        }
        public int getYear() {
            return year(birthday);
        }
        public int getMonth() {
            return month(birthday);
        }
        public int getDay() {
            return day(birthday);
        }
        @Override
        public String toString() {
            return customerCode + " " + customerName + " " + sex + " " + address + " " + birthday;
        }
    }
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            String customerCode = "KH" + String.format("%03d", i);
            String customerName = transName(scanner.nextLine()),
                    sex = scanner.nextLine(),
                    birthday = transBirthday(scanner.nextLine()),
                    address = scanner.nextLine();
            customers.add(new Customer(customerCode, customerName, sex, address, birthday));
        }
        customers.sort(
                Comparator.comparing(Customer::getYear)
                        .thenComparing(Customer::getMonth)
                        .thenComparing(Customer::getDay)
        );
        customers.forEach(System.out::println);
        scanner.close();
    }
}
