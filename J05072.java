import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class J05072 {
    static class Phone {
        private String provinceName;
        private long cost;

        public Phone(String provinceName, long cost) {
            this.provinceName = provinceName;
            this.cost = cost;
        }
    }

    static class User {
        private String phoneNumber, provinceName;
        private long time, total;

        public User(String phoneNumber, String provinceName, long time, long total) {
            this.phoneNumber = phoneNumber;
            this.provinceName = provinceName;
            this.time = time;
            this.total = total;
        }
        public long getTotal() {
            return total;
        }
        public String toString() {
            return phoneNumber + " " + provinceName + " " + time + " " + total;
        }
    }
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Phone> map = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String areaCode = scanner.nextLine(),
                    provinceName = scanner.nextLine();
            long cost = scanner.nextLong();
            map.put(areaCode, new Phone(provinceName, cost));
        }
        scanner.nextLine();
        int m = Integer.parseInt(scanner.nextLine());
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i <= m; ++i) {
            String numberPhone = scanner.next(), begin = scanner.next(), end = scanner.next();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date1 = sdf.parse(begin), date2 = sdf.parse(end);
            long time = (date2.getTime() - date1.getTime()) / 60000;
            if (numberPhone.charAt(0) == '0') {
                String code = numberPhone.substring(1, 3);
                Phone phone = map.get(code);
                users.add(new User(numberPhone, phone.provinceName, time, time * phone.cost));
            }
            else {
                time = (time + 2) / 3;
                users.add(new User(numberPhone, "Noi mang", time, time * 800));
            }
        }
        users.sort(
                Comparator.comparing(User::getTotal, Comparator.reverseOrder())
        );
        users.forEach(System.out::println);
        scanner.close();
    }
}
