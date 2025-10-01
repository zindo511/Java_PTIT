import java.math.BigInteger;
import java.util.Scanner;

public class J04014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            BigInteger a = scanner.nextBigInteger(),
                    b = scanner.nextBigInteger(),
                    c = scanner.nextBigInteger(),
                    d = scanner.nextBigInteger();

            BigInteger tu_c = (a.multiply(d).add(b.multiply(c))).multiply(a.multiply(d).add(b.multiply(c)));
            BigInteger mau_c = b.multiply(b).multiply(d).multiply(d);

            BigInteger g = tu_c.gcd(mau_c);
            tu_c = tu_c.divide(g);
            mau_c = mau_c.divide(g);

            BigInteger tu_d = a.multiply(c).multiply(tu_c),
                    mau_d = b.multiply(d).multiply(mau_c);
            g = tu_d.gcd(mau_d);

            tu_d = tu_d.divide(g);
            mau_d = mau_d.divide(g);
            System.out.println(tu_c + "/" + mau_c + " " + tu_d + "/" + mau_d);

        }
        scanner.close();
    }
}
