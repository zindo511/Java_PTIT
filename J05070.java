import java.util.*;

public class J05070 {
    static class Football {
        private String ma, ten;
        private int giaVe;

        public Football(String ma, String ten, int giaVe) {
            this.ma = ma;
            this.ten = ten;
            this.giaVe = giaVe;
        }
    }

    static class TranDau {
        private String ma, ten;
        private long doanhThu;

        public TranDau(String ma, String ten, long doanhThu) {
            this.ma = ma;
            this.ten = ten;
            this.doanhThu = doanhThu;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + doanhThu;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        Map<String, Football> map = new HashMap<>();
        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine();
            int giaVe = scanner.nextInt();
            map.put(ma, new Football(ma, ten, giaVe));
        }

        ArrayList<TranDau> dsTran = new ArrayList<>();
        int q = scanner.nextInt();
        scanner.nextLine();
        while (q-- > 0) {
            String s = scanner.next();
            int cdv = scanner.nextInt();
            String ma = s.substring(1, 3);

            Football fb = map.get(ma);

            long doanhThu = (long) fb.giaVe * cdv;
            dsTran.add(new TranDau(s, fb.ten, doanhThu));
        }

        dsTran.sort(
                Comparator.comparing((TranDau trandau) -> trandau.doanhThu, Comparator.reverseOrder())
                        .thenComparing((TranDau trandau) -> trandau.ten)
        );

        dsTran.forEach(System.out::println);
        scanner.close();
    }
}
