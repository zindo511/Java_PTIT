import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class J05016 {
    static int trans(String s){
        Character floor = s.charAt(0);
        if (floor == '1') return 25;
        if (floor == '2') return 34;
        if (floor == '3') return 50;
        return 80;
    }
    static class Bill {
        String customerCode, customerName, roomNum;
        long time, total;

        public Bill(String customerCode, String customerName, String roomNum, long time, long total) {
            this.customerCode = customerCode;
            this.customerName = customerName;
            this.roomNum = roomNum;
            this.time = time;
            this.total = total;
        }
        public long getTotal(){
            return total;
        }
        @Override
        public String toString(){
            return customerCode + " " + customerName + " " + roomNum + " " + time + " " + total;
        }
    }
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Bill> bills = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String customerCode = "KH" + String.format("%02d", i),
                    customerName = scanner.nextLine(),
                    roomNum = scanner.nextLine(),
                    dayBegin = scanner.nextLine(),
                    dayEnd = scanner.nextLine();
            int service = scanner.nextInt();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = sdf.parse(dayBegin),
                    date2 = sdf.parse(dayEnd);
            long time = (date2.getTime() - date1.getTime()) / 86400000 + 1;
            long total = time * trans(roomNum) + service;
            bills.add(new Bill(customerCode, customerName, roomNum, time, total));
        }
        bills.sort(
                Comparator.comparing(Bill::getTotal, Comparator.reverseOrder())
        );
        bills.forEach(System.out::println);
        scanner.close();
    }
}
