import java.util.ArrayList;
import java.util.Scanner;

public class J05036 {
    static class Store {
        private String ten, dvi, ma;
        private int nhap, soLuong;

        public Store(String ma, String ten, String dvi, int nhap, int soLuong) {
            this.ma = ma;
            this.ten = ten;
            this.dvi = dvi;
            this.nhap = nhap;
            this.soLuong = soLuong;
        }

        @Override
        public String toString() {
            double phiVanChuyen = (nhap * soLuong) * 5 / 100,
                    thanhTien = nhap * soLuong + phiVanChuyen,
                    giaBan = thanhTien * 102 / 100;
            return "MH" + ma + " " + ten + " " + dvi + " " + String.format("%.0f", phiVanChuyen) + " " +
                    String.format("%.0f", thanhTien) + " " + String.format("%.0f", giaBan);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Store> stores = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String ma = String.valueOf(i);
            while (ma.length() < 2) ma = "0" + ma;
            String ten = scanner.nextLine(),
                    dvi = scanner.nextLine();
            int nhap = scanner.nextInt(),
                    soLuong = scanner.nextInt();
            stores.add(new Store(ma, ten, dvi, nhap, soLuong));
        }

        stores.forEach(System.out::println);
        scanner.close();
    }
}
