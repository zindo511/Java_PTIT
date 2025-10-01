import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J05071 {
    static class Phone {
        private String provinceName;
        private long cost;

        public Phone(String provinceName, long cost) {
            this.provinceName = provinceName;
            this.cost = cost;
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
        for (int i = 1; i <= m; ++i) {
            String numberPhone = scanner.next(), begin = scanner.next(), end = scanner.next();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date1 = sdf.parse(begin), date2 = sdf.parse(end);
            long time = (date2.getTime() - date1.getTime()) / 60000;
            if (numberPhone.charAt(0) == '0') {
                String code = numberPhone.substring(1, 3);
                Phone phone = map.get(code);
                System.out.println(numberPhone + " " + phone.provinceName + " " + time + " " + time * phone.cost);
            }
            else {
                time = (time + 2) / 3;
                System.out.println(numberPhone + " " + "Noi mang" + " " + time + " " + time * 800);
            }
        }
        scanner.close();
    }
}
