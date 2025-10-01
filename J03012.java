import java.math.BigInteger;
import java.util.Scanner;

public class J03012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            BigInteger x = scanner.nextBigInteger(),
                    y = scanner.nextBigInteger();
            System.out.println(x.add(y));
        }
        scanner.close();
    }
}
