import java.math.BigInteger;
import java.util.Scanner;

public class J03039 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            BigInteger a = scanner.nextBigInteger();
            BigInteger b = scanner.nextBigInteger();

            BigInteger mod1 = a.mod(b);
            BigInteger mod2 = b.mod(a);

            int result1 = mod1.compareTo(BigInteger.ZERO);
            int result2 = mod2.compareTo(BigInteger.ZERO);
            if (result1 == 0 || result2 == 0) System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
