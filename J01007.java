import java.util.Scanner;

public class J01007 {
    static long[] fibo = new long[94];
    static void fibonaci() {
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= 93; ++i) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
    }

    static boolean check(long n) {
        for (int i = 0; i <= 92; ++i) {
            if (n == fibo[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        fibonaci();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            if (check(n)) System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
