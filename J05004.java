import java.util.ArrayList;
import java.util.Scanner;

public class J05004 {
    static String trans(String s) {
        String[] parts = s.split("/");
        if (parts[0].length() == 1) parts[0] = "0" + parts[0];
        if (parts[1].length() == 1) parts[1] = "0" + parts[1];
        return parts[0] + "/" + parts[1] + "/" + parts[2];
    }

    static String name(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i) {
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1).toLowerCase() + " ");
        }
        return res.toString().trim();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String ten = scanner.nextLine(),
                    lop = scanner.nextLine(),
                    ns = scanner.nextLine();
            double gpa = scanner.nextDouble();

            String ma = "B20DCCN" + String.format("%03d", i);
            System.out.println(ma + " " + name(ten) + " " + lop + " " + trans(ns) + " " + String.format("%.2f", gpa));
        }
        scanner.close();
    }
}
