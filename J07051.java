import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07051 {
    static String trans(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i)
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1) + " ");
        return res.toString().trim();
    }

    static int check(String s) {
        return Integer.parseInt(s.trim());
    }

    static long donGia(String s) {
        char x = s.charAt(0);
        if (x == '1') return 25;
        if (x == '2') return 34;
        if (x == '3') return 50;
        return 80;
    }

    static class Calculate {
        private String customerID, fullName, roomNum;
        private long numDay, money;

        public Calculate(String customerID, String fullName, String roomNum, long numDay, long money) {
            this.customerID = customerID;
            this.fullName = fullName;
            this.roomNum = roomNum;
            this.numDay = numDay;
            this.money = money;
        }

        @Override
        public String toString() {
            return  customerID + " " + fullName + " " + roomNum + " " + numDay + " " + money;
        }
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("KHACHHANG.in"));
            int n = scanner.nextInt();

            ArrayList<Calculate> calculates = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                scanner.nextLine();
                String customerID = "KH" + String.format("%02d", i),
                        fullName = scanner.nextLine(),
                        roomNum = scanner.nextLine(),
                        dateIn = scanner.nextLine(),
                        dateOut = scanner.nextLine();
                int serviceMoney = scanner.nextInt();

                String[] parts1 = dateIn.split("/"),
                        parts2 = dateOut.split("/");
                LocalDate start = LocalDate.of(check(parts1[2]), check(parts1[1]), check(parts1[0])),
                        end = LocalDate.of(check(parts2[2]), check(parts2[1]), check(parts2[0]));

                long numDay = ChronoUnit.DAYS.between(start, end) + 1,
                        money = donGia(roomNum) * numDay + serviceMoney;
                calculates.add(new Calculate(customerID, trans(fullName), roomNum, numDay, money));
            }

            calculates.sort(
                    Comparator.comparing((Calculate calculate) -> calculate.money, Comparator.reverseOrder())
            );
            calculates.forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
