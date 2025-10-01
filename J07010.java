import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07010 {
    static String trans(String ns) {
        String[] parts = ns.split("/");
        String d = String.format("%02d", Integer.parseInt(parts[0]));
        String m = String.format("%02d", Integer.parseInt(parts[1]));
        String y = String.format("%02d", Integer.parseInt(parts[2]));
        return d + "/" + m + "/" + y;
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("SV.in"));
            int n = scanner.nextInt();
            for (int i = 1; i <= n; ++i) {
                scanner.nextLine();
                String ma = "B20DCCN" + String.format("%03d", i);
                String ten = scanner.nextLine(),
                        lop = scanner.nextLine(),
                        ns = scanner.nextLine();
                double gpa = scanner.nextDouble();
                System.out.println(ma + " " + ten + " "+ lop + " " + trans(ns) + " " + String.format("%.2f", gpa));
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {

        }
    }
}
