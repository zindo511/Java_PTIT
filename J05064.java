import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J05064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String maNgach = scanner.nextLine(),
                    ten = scanner.nextLine();
            long luongCoBan = scanner.nextLong();

            String chucVu = maNgach.substring(0, 2), heSoBacLuong = maNgach.substring(maNgach.length() - 2);
            int bacLuong = Integer.valueOf(heSoBacLuong), phuCap;

            if (chucVu.equals("HT")) phuCap = 2000000;
            else if (chucVu.equals("HP")) phuCap =  900000;
            else phuCap = 500000;

            long thuNhap = luongCoBan * bacLuong + phuCap;

            countMap.put(chucVu, countMap.getOrDefault(chucVu, 0) + 1);
            if ((chucVu.equals("HT") && countMap.get("HT") > 1) || (chucVu.equals("HP") && countMap.get("HP") > 2))
                continue;

            System.out.println(maNgach + " " + ten + " " + bacLuong + " " + phuCap + " " + thuNhap);
        }
        scanner.close();

    }
}
