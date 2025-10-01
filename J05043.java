import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class J05043 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String ma = "NV" + String.format("%02d", i);
            String ten = scanner.nextLine(),
                    chucVu = scanner.nextLine();
            int luong = scanner.nextInt(),
                    ngayCong = scanner.nextInt();
            int phuCap, luongChinh = luong * ngayCong, tamUng, conLai;
            if (chucVu.equals("GD")) phuCap = 500;
            else if (chucVu.equals("PGD")) phuCap = 400;
            else if (chucVu.equals("TP")) phuCap = 300;
            else if (chucVu.equals("KT")) phuCap = 250;
            else phuCap = 100;

            double val = (phuCap + luongChinh) * 2.0 / 3;
            if (val < 25000){
                tamUng = (int) Math.round(val / 1000) * 1000;
            }
            else tamUng = 25000;
            conLai = luongChinh + phuCap - tamUng;
            System.out.println(ma + " " + ten + " " + phuCap + " " + luongChinh + " " + tamUng + " " + conLai);
        }
        scanner.close();
    }
}
