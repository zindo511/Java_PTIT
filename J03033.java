import java.math.BigInteger;
import java.util.Scanner;

public class J03033 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            BigInteger a = new BigInteger(scanner.nextLine());
            BigInteger b = new BigInteger(scanner.nextLine());

            BigInteger gcd = a.gcd(b);
            BigInteger mul = a.multiply(b);
            System.out.println(mul.divide(gcd));
        }
        scanner.close();
    }
}
