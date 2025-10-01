import java.util.Scanner;

public class J04012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ten = scanner.nextLine();
        long luong = scanner.nextLong(),
                ngayCong = scanner.nextLong();
        scanner.nextLine();
        String chucVu = scanner.nextLine();

        long thuong, phuCap, luongThang = luong * ngayCong;
        if (ngayCong >= 25) thuong = luongThang * 20 / 100;
        else if (ngayCong >= 22) thuong = luongThang * 10 / 100;
        else thuong = 0;

        if (chucVu.equals("GD")) phuCap = 250000;
        else if (chucVu.equals("PGD")) phuCap = 200000;
        else if (chucVu.equals("TP")) phuCap = 180000;
        else phuCap = 150000;

        System.out.println("NV01 " + ten + " " + luongThang + " " + thuong + " " + phuCap + " " + (luongThang + thuong + phuCap));
        scanner.close();
    }
}
