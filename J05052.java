import java.util.Scanner;

public class J05052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i){
            scanner.nextLine();
            String tenHang = scanner.nextLine(),
                    maDonHang = scanner.nextLine();
            int donGia = scanner.nextInt(),
                    soLuong = scanner.nextInt();

            int giamGia, thanhTien;
            String stt = maDonHang.substring(1, 4);

            if (maDonHang.charAt(maDonHang.length() - 1) == '1') giamGia = (int) Math.round(donGia * soLuong * 0.5);
            else giamGia = (int) Math.round(donGia * soLuong * 0.3);

            thanhTien = donGia * soLuong - giamGia;
            System.out.println(tenHang + " " + maDonHang + " " + stt + " " + giamGia + " " + thanhTien);
        }
        scanner.close();
    }
}
