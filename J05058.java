import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05058 {
    static class Sum {
        private String ma, ten, status;
        private double toan, ly, hoa, ut, tong;

        public Sum(String ma, String ten, double toan, double ly, double hoa, double ut, double tong, String status) {
            this.ma = ma;
            this.ten = ten;
            this.toan = toan;
            this.ly = ly;
            this.hoa = hoa;
            this.ut = ut;
            this.tong = tong;
            this.status = status;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + trans(ut) + " " + trans(tong) + " " + status;
        }
    }
    static double uuTien(String kv) {
        if (kv.equals("KV1")) return 0.5;
        if (kv.equals("KV2")) return 1;
        return 2.5;
    }

    static String status(double x) {
        if (x >= 24) return "TRUNG TUYEN";
        return "TRUOT";
    }

    static String trans(double x) {
        if (x == (long) x)
            return String.valueOf((long) x);
        return String.valueOf(x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Sum> sums = new ArrayList<>();
        while (t-- > 0) {
            scanner.nextLine();
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine();
            double toan = scanner.nextDouble(),
                    ly = scanner.nextDouble(),
                    hoa = scanner.nextDouble();

            String kv = ma.substring(0, 3);
            double ut = uuTien(kv), tong = toan * 2 + ly + hoa;
            sums.add(new Sum(ma, ten, toan, ly, hoa, ut, (tong + ut), status(tong + ut)));
        }

        sums.sort(
                Comparator.comparing((Sum sum) -> sum.tong, Comparator.reverseOrder())
                        .thenComparing((Sum sum) -> sum.ma)
        );

        sums.forEach(System.out::println);
        scanner.close();
    }
}
