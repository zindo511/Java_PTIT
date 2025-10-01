import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class J07046 {
    static int trans(String s){
        return Integer.valueOf(s);
    }

    static class Customer {
        private String customerID, fullName, roomCode;
        private long numDay;

        public Customer(String customerID, String fullName, String roomCode, long numDay) {
            this.customerID = customerID;
            this.fullName = fullName;
            this.roomCode = roomCode;
            this.numDay = numDay;
        }

        @Override
        public String toString() {
            return customerID + " " + fullName + " " + roomCode + " " + numDay;
        }
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("KHACH.in"));
            int n = scanner.nextInt();
            scanner.nextLine();

            ArrayList<Customer> customers = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                String customerID = "KH" + String.format("%02d", i),
                        fullName = scanner.nextLine(),
                        roomCode = scanner.nextLine(),
                        dateIn = scanner.nextLine(),
                        dateOut = scanner.nextLine();
                String[] parts1 = dateIn.split("/");
                String[] parts2 = dateOut.split("/");
                LocalDate startDate = LocalDate.of(trans(parts1[2]), trans(parts1[1]), trans(parts1[0])),
                        endDate = LocalDate.of(trans(parts2[2]), trans(parts2[1]), trans(parts2[0]));
                long numDay = ChronoUnit.DAYS.between(startDate, endDate);
                customers.add(new Customer(customerID, fullName, roomCode, numDay));
            }
            customers.sort(
                    Comparator.comparing((Customer customer) -> customer.numDay, Comparator.reverseOrder())
            );
            customers.forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
