import java.util.Scanner;

public class J05048 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String maHang = scanner.nextLine();
            int soLuongNhap = scanner.nextInt(), soLuongXuat, donGia, tien, thue;

            double tmp;
            if (maHang.charAt(0) == 'A') tmp = soLuongNhap * 0.6;
            else tmp = soLuongNhap * 0.7;
            soLuongXuat = (int) (Math.round(tmp));

            if (maHang.charAt(maHang.length() - 1) == 'Y') donGia = 110000;
            else donGia = 135000;

            tien = soLuongXuat * donGia;

            char begin = maHang.charAt(0), end = maHang.charAt(maHang.length() - 1);
            if (begin == 'A' && end == 'Y') thue = (int) (Math.round(tien * 0.08));
            else if (begin == 'A' && end == 'N') thue = (int) (Math.round(tien * 0.11));
            else if (begin == 'B' && end == 'Y') thue = (int) (Math.round(tien * 0.17));
            else thue = (int) (Math.round(tien * 0.22));

            System.out.println(maHang + " " + soLuongNhap + " " + soLuongXuat + " " + donGia + " " + tien + " " + thue);
        }
        scanner.close();
    }
}
