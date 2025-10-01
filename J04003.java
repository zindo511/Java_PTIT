import java.math.BigInteger;
import java.util.Scanner;

public class J04003 {
    static class Fraction {
        private long x, y;

        public Fraction(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public static void rutgon(Fraction p){
            long gcd = BigInteger.valueOf(p.x).gcd(BigInteger.valueOf(p.y)).longValue();
            System.out.println(p.x / gcd + "/" + p.y / gcd);
        }


    }
    public static void main(String[] args) {
        long x, y;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextLong();
        y = scanner.nextLong();

        Fraction p = new Fraction(x, y);
        Fraction.rutgon(p);
        scanner.close();
    }
}
