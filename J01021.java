import java.util.Scanner;

public class J01021 {
    static long MOD = 1000000007;
    static long powerMod(long a, long b) {
        long sum = 1;
        while (b != 0) {
            if (b % 2 == 1){
                sum = (sum * a) % MOD;
            }
            a = (a * a) % MOD;
            b /= 2;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            long a, b;
            a = scanner.nextLong();
            b = scanner.nextLong();
            if (a == 0 && b == 0) break;

            System.out.println(powerMod(a, b));
        }
        scanner.close();
    }
}
