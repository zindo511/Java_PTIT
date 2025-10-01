import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05049 {
    static class Group {
        private String maHang;
        private int soLuongNhap, soLuongXuat, donGia, tien, thue;

        public Group (String maHang, int soLuongNhap, int soLuongXuat, int donGia, int tien, int thue) {
            this.maHang = maHang;
            this.soLuongNhap = soLuongNhap;
            this.soLuongXuat = soLuongXuat;
            this.donGia = donGia;
            this.tien = tien;
            this.thue = thue;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Group> groups = new ArrayList<>();
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

            groups.add(new Group(maHang, soLuongNhap, soLuongXuat, donGia, tien, thue));
        }

        groups.sort(
                Comparator.comparing((Group group) -> group.thue, Comparator.reverseOrder())
        );
        scanner.nextLine();
        String s = scanner.nextLine();
        for (int i = 0; i < groups.size(); ++i) {
            Group x = groups.get(i);
            if (x.maHang.charAt(0) == s.charAt(0)) System.out.println(x.maHang + " " + x.soLuongNhap + " " + x.soLuongXuat + " " +
                    x.donGia + " " + x.tien + " " + x.thue);
        }
        scanner.close();
    }
}
