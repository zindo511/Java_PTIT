import java.util.Scanner;

public class practiceb2 {
    static long[] fibo = new long[94];
    static void fib() {
        fibo[0] = 0;
        fibo[1] = fibo[2] = 1;
        for (int i = 3; i <= 93; ++i)
            fibo[i] = fibo[i - 1] + fibo[i - 2];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        fib();
        while (t-- > 0) {
            long n = scanner.nextLong();
            int check = 1;
            for (int i = 0; i <= 93; ++i)
                if (n == fibo[i]) {
                    System.out.println("YES");
                    check = 0;
                    break;
                }
            if (check == 1) System.out.println("NO");
        }
        scanner.close();
    }
}
