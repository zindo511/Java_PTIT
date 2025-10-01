import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07053 {
    static String trans(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i)
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1) + " ");
        return res.toString().trim();
    }

    static int age(String s) {
        String[] parts = s.split("/");
        return 2021 - Integer.valueOf(parts[parts.length - 1]);
    }

    static int dtb(double diemLiThuyet, double diemThucHanh, double diemThuong) {
        int dtb = (int) Math.round((diemLiThuyet + diemThucHanh) / 2 + diemThuong);
        if (dtb > 10) return 10;
        return dtb;
    }

    static String xeploai(int dtb) {
        if (dtb == 9 || dtb == 10) return "Xuat sac";
        if (dtb == 8) return "Gioi";
        if (dtb == 7) return "Kha";
        if (dtb >= 5 && dtb <= 6) return "Trung binh";
        return "Truot";
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("XETTUYEN.in"));
            int t = scanner.nextInt();

            for (int i = 1; i <= t; ++i) {
                scanner.nextLine();
                String ma = "PH" + String.format("%02d", i);
                String ten = scanner.nextLine(),
                        ngaySinh = scanner.nextLine();

                double diemLiThuyet = scanner.nextDouble(),
                        diemThucHanh = scanner.nextDouble();
                int tuoi = age(ngaySinh);

                double diemThuong;
                if (diemLiThuyet >= 8 && diemThucHanh >= 8) diemThuong = 1;
                else if (diemLiThuyet >= 7.5 && diemThucHanh >= 7.5) diemThuong = 0.5;
                else diemThuong = 0;

                int diemTrungBinh = dtb(diemLiThuyet, diemThucHanh, diemThuong);
                String xepLoai = xeploai(diemTrungBinh);
                System.out.println(ma + " " + trans(ten) + " " + tuoi + " " + diemTrungBinh + " " + xepLoai);
            }
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
