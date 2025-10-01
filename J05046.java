import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J05046 {
    static String ma(String s) {
        String[] parts = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 2; ++i)
            res.append(parts[i].toUpperCase().charAt(0));
        return res.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        Map<String, Integer> countMap = new HashMap<>();
        while (t-- > 0) {
            scanner.nextLine();
            String ten = scanner.nextLine();
            int soLuong = scanner.nextInt(),
                    donGia = scanner.nextInt();

            double phanTramChietKhau;
            if (soLuong < 5) phanTramChietKhau = 0;
            else if (soLuong < 8) phanTramChietKhau = 0.01;
            else if (soLuong <= 10) phanTramChietKhau = 0.02;
            else phanTramChietKhau = 0.05;

            int tienChietKhau = (int) (donGia * soLuong * phanTramChietKhau), thanhTien = soLuong * donGia - tienChietKhau;
            String code = ma(ten);
            countMap.put(code, countMap.getOrDefault(code, 0) + 1);
            System.out.println(code + "0" + countMap.get(code) + " " + ten + " " + tienChietKhau + " " + thanhTien);
        }
        scanner.close();
    }
}
