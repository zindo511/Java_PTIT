import java.util.Scanner;

public class J05073 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String code = scanner.next();
            long price = scanner.nextLong(), num = scanner.nextLong();
            double tax, feeShip;
            if (code.charAt(0) == 'T') {
                tax = price * num * 0.29;
                feeShip = price * num * 0.04;
            }
            else if (code.charAt(0) == 'C') {
                tax = price * num * 0.1;
                feeShip = price * num * 0.03;
            }
            else if (code.charAt(0) == 'D') {
                tax = price * num * 0.08;
                feeShip = price * num * 0.025;
            }
            else {
                tax = price * num * 0.02;
                feeShip = price * num * 0.005;
            }
            if (code.charAt(code.length() - 1) == 'C')
                tax = tax * 0.95;
            System.out.println(code + " " + String.format("%.02f", (price * num + tax + feeShip) * 1.2 / num));
        }
        scanner.close();
    }
}
