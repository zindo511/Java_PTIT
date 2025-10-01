import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05061 {
    static class Result {
        private String ma, ten, xepLoai;
        private int diemTrungBinh, tuoi;

        public Result(String ma, String ten, int tuoi, int diemTrungBinh, String xepLoai) {
            this.ma = ma;
            this.ten = ten;
            this.tuoi = tuoi;
            this.diemTrungBinh = diemTrungBinh;
            this.xepLoai = xepLoai;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + tuoi + " " + diemTrungBinh + " " + xepLoai;
        }
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
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Result> results = new ArrayList<>();
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
            results.add(new Result(ma, ten, tuoi, diemTrungBinh, xepLoai));
        }

        results.sort(
                Comparator.comparing((Result result) -> result.diemTrungBinh, Comparator.reverseOrder())
                        .thenComparing((Result result) -> result.ma)
        );

        results.forEach(System.out::println);
        scanner.close();
    }
}
