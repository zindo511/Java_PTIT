import java.math.BigInteger;
import java.util.Scanner;

public class J03015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = scanner.nextBigInteger(),
                b = scanner.nextBigInteger();

        System.out.println(a.subtract(b));
        scanner.close();
    }
}
