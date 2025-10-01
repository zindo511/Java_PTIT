import java.util.Scanner;

public class J05006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= t; ++i) {
            String ma = String.format("%05d", i);
            String ten = scanner.nextLine(),
                    gt = scanner.nextLine(),
                    ns = scanner.nextLine(),
                    dc = scanner.nextLine(),
                    mst = scanner.nextLine(),
                    nkhd = scanner.nextLine();
            System.out.println(ma + " " + ten + " " + gt + " " + ns + " " + dc + " " + mst + " " + nkhd);
        }
        scanner.close();
    }
}
