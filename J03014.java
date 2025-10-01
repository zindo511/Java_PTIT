import java.math.BigInteger;
import java.util.Scanner;

public class J03014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger A = scanner.nextBigInteger(),
                B = scanner.nextBigInteger();
        System.out.println(A.add(B));
        scanner.close();
    }
}
