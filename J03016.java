import java.math.BigInteger;
import java.util.Scanner;

public class J03016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            BigInteger a = scanner.nextBigInteger();
            if (a.mod(BigInteger.valueOf(11)).equals(BigInteger.ZERO)) System.out.println(1);
            else System.out.println(0);
        }
        scanner.close();
    }
}
