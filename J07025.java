import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class J07025 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Customer> customers = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 1; i <= n; ++i) {
            String codeCustomer = "KH" + String.format("%03d", i),
                    fullName = transName(scanner.nextLine()),
                    gender = scanner.nextLine(),
                    birth = transBirth(scanner.nextLine()),
                    address = scanner.nextLine();
            Date date = sdf.parse(birth);
            customers.add(new Customer(codeCustomer, fullName, gender, address, birth, date));
        }

        customers.sort(
                Comparator.comparing(Customer::getDate)
        );

        customers.forEach(System.out::println);
        scanner.close();
    }

    static String transName(String fullName) {
        fullName = fullName.trim().toLowerCase();
        String[] parts = fullName.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts)
            sb.append(part.substring(0, 1).toUpperCase()).append(part.substring(1)).append(" ");
        return sb.toString().trim();
    }

    static String transBirth(String birth) {
        String[] parts = birth.split("/");
        StringBuilder sb = new StringBuilder();
        if (parts[0].length() == 1) parts[0] = "0" + parts[0];
        if (parts[1].length() == 1) parts[1] = "0" + parts[1];
        for (String part : parts)
            sb.append(part).append("/");
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    static class Customer {
        String codeCustomer, fullName,gender, address, birth;
        Date date;
        public Customer(String codeCustomer, String fullName, String gender, String address, String birth, Date date) {
            this.codeCustomer = codeCustomer;
            this.fullName = fullName;
            this.gender = gender;
            this.address = address;
            this.birth = birth;
            this.date = date;
        }

        public Date getDate() {
            return date;
        }

        public String toString() {
            return codeCustomer + " " + fullName + " " + gender + " " + address + " " + birth;
        }
    }

}
