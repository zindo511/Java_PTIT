import java.util.ArrayList;
import java.util.Scanner;

public class J05050 {
    static class Money {
        String ma, loai;
        int cu, moi;

        public Money(String ma, String loai, int cu, int moi) {
            this.ma = ma;
            this.loai = loai;
            this.cu = cu;
            this.moi = moi;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Money> monies = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String ma = String.valueOf(i);
            while (ma.length() < 2) ma = "0" + ma;

            String loai = scanner.nextLine();
            int cu = scanner.nextInt(),
                    moi = scanner.nextInt();
            monies.add(new Money(ma, loai, cu, moi));
        }

        for (int i = 0; i < monies.size(); ++i) {
            long heSo, thanhTien;
            long phuTro;

            Money money = monies.get(i);
            if (money.loai.equals("KD")) heSo = 3;
            else if (money.loai.equals("NN")) heSo = 5;
            else if (money.loai.equals("TT")) heSo = 4;
            else heSo = 2;

            thanhTien = (money.moi - money.cu) * heSo * 550;
            if ((money.moi - money.cu) < 50) phuTro = 0;
            else if ((money.moi - money.cu) <= 100) phuTro = Math.round(thanhTien * 35 / 100.0);
            else phuTro = thanhTien;

//            long phuTroNew = Math.round(phuTroi);
            long tongTien = phuTro + thanhTien;
            System.out.println("KH" + money.ma + " " + heSo + " " + thanhTien + " " + phuTro + " " + tongTien);
        }
        scanner.close();
    }
}
