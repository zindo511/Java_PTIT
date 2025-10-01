import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05053 {
    static class Order {
        private String tenHang, maDonHang, stt;
        private int giamGia, thanhTien;

        public Order(String tenHang, String maDonHang, String stt, int giamGia, int thanhTien) {
            this.tenHang = tenHang;
            this.maDonHang = maDonHang;
            this.stt = stt;
            this.giamGia = giamGia;
            this.thanhTien = thanhTien;
        }

        @Override
        public String toString() {
            return tenHang + " " + maDonHang + " " + stt + " " + giamGia + " " + thanhTien;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Order> orders = new ArrayList<>();
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
            orders.add(new Order(tenHang, maDonHang, stt, giamGia, thanhTien));
        }

        orders.sort(
                Comparator.comparing((Order order) -> order.stt)
        );

        orders.forEach(System.out::println);
        scanner.close();
    }
}
