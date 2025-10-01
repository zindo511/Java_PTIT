import java.math.BigInteger;
import java.util.Scanner;

public class J04004 {
    static class Plus {
        private long x, y;

        public Plus(long x, long y) {
            this.x = x;
            this.y = y;
        }

        static void plus(Plus p1, Plus p2) {
            long gcd1 = BigInteger.valueOf(p1.x).gcd(BigInteger.valueOf(p1.y)).longValue();
            long gcd2 = BigInteger.valueOf(p2.x).gcd(BigInteger.valueOf(p2.y)).longValue();

            p1.x = p1.x / gcd1;
            p1.y = p1.y / gcd1;

            p2.x = p2.x / gcd2;
            p2.y = p2.y / gcd2;

            Plus p3 = new Plus(p1.x * p2.y + p2.x * p1.y, p1.y * p2.y);
            long gcd3 = BigInteger.valueOf(p3.x).gcd(BigInteger.valueOf(p3.y)).longValue();
            System.out.println(p3.x / gcd3 + "/" + p3.y / gcd3);
        }
    }

    public static void main(String[] args) {
        long x1, y1, x2, y2;
        Scanner scanner = new Scanner(System.in);
        x1 = scanner.nextLong();
        y1 = scanner.nextLong();
        x2 = scanner.nextLong();
        y2 = scanner.nextLong();

        Plus p1 = new Plus(x1, y1);
        Plus p2 = new Plus(x2, y2);

        Plus.plus(p1, p2);

        scanner.close();
    }
}
