import java.util.Scanner;

public class J04015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ma, name;
        ma = scanner.nextLine();
        name = scanner.nextLine();
        Long luong = scanner.nextLong();

        String pc = ma.substring(0,2),
                heso = ma.substring(2);
        int heSo = Integer.valueOf(heso);
        int phuCap;

        if (pc.equals("HT")) phuCap = 2000000;
        else if (pc.equals("HP")) phuCap = 900000;
        else phuCap = 500000;

        System.out.println(ma + " " + name + " " + heSo + " " + phuCap + " " + (luong * heSo + phuCap));
        scanner.close();
    }
}
