import java.util.ArrayList;
import java.util.Scanner;

public class J05040 {
    static class Sheet {
        private String ma, ten, chucVu;
        long luong, soNgayCong;

        public Sheet(String ma, String ten, long luong, long soNgayCong, String chucVu) {
            this.ma = ma;
            this.ten = ten;
            this.luong = luong;
            this.soNgayCong = soNgayCong;
            this.chucVu = chucVu;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Sheet> sheets = new ArrayList<>();
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= t; ++i) {
            String ma = String.valueOf(i);
            while (ma.length() < 2) ma = "0" + ma;

            String ten = scanner.nextLine();
            long luong = scanner.nextLong(),
                    soNgayCong = scanner.nextLong();
            scanner.nextLine();
            String chucVu = scanner.nextLine();
            sheets.add(new Sheet(ma, ten, luong, soNgayCong, chucVu));
        }

        for (int i = 0; i < sheets.size(); ++i) {
            Sheet sheet = sheets.get(i);
            long thuong, phuCap, luongThang = sheet.luong * sheet.soNgayCong;
            if (sheet.soNgayCong >= 25) thuong = luongThang* 20 / 100;
            else if (sheet.soNgayCong >= 22) thuong = luongThang * 10 / 100;
            else thuong = 0;

            if (sheet.chucVu.equals("GD")) phuCap = 250000;
            else if (sheet.chucVu.equals("PGD")) phuCap = 200000 ;
            else if (sheet.chucVu.equals("TP")) phuCap = 180000;
            else phuCap = 150000;

            long thucLinh = luongThang + thuong + phuCap;

            System.out.println("NV" + sheet.ma + " " + sheet.ten + " " + luongThang + " " + thuong + " " +
                    phuCap + " " + thucLinh);
        }
        scanner.close();
    }
}
