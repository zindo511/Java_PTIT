import java.util.Scanner;

public class J05057 {
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
        while (t-- > 0) {
            scanner.nextLine();
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine();
            double toan = scanner.nextDouble(),
                    ly = scanner.nextDouble(),
                    hoa = scanner.nextDouble();

            String kv = ma.substring(0, 3);
            double ut = uuTien(kv), tong = toan * 2 + ly + hoa;
            System.out.println(ma + " " + ten + " " + trans(ut) + " " + trans(tong)+ " " + status(tong + ut));
        }
        scanner.close();
    }
}
