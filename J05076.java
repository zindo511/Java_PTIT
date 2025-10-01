import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J05076 {
    static class Import {
        private String ma, ten, xepLoai;

        public Import(String ma, String ten, String xepLoai) {
            this.ma = ma;
            this.ten = ten;
            this.xepLoai = xepLoai;
        }
    }

    static class Export {
        private String ma, ten;
        private long tongNhap, tongXuat;

        public Export(String ma, String ten, long tongNhap, long tongXuat) {
            this.ma = ma;
            this.ten = ten;
            this.tongNhap = tongNhap;
            this.tongXuat = tongXuat;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine();
        Map<String, Import> map = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine(),
                    xepLoai = scanner.nextLine();
            map.put(ma, new Import(ma, ten, xepLoai));
        }

        int q = scanner.nextInt();
        while (q-- > 0) {
            String ma = scanner.next();
            long soLuongNhap = scanner.nextLong(),
                    donGiaNhap = scanner.nextLong(),
                    soLuongXuat = scanner.nextLong();

            String ten = map.get(ma).ten, code = map.get(ma).xepLoai;
            long tongGiaTriNhap = soLuongNhap * donGiaNhap,
                    xuat = soLuongXuat * donGiaNhap;
            if (code.equals("A")) xuat = xuat + xuat * 8 / 100;
            else if (code.equals("B")) xuat = xuat + xuat * 5 / 100;
            else xuat = xuat + xuat * 2 / 100;
            System.out.println(ma + " " + ten + " " + tongGiaTriNhap + " " + xuat);
        }
        scanner.close();
    }
}
