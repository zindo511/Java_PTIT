import java.util.Scanner;

public class J01006 {
    static long[] fibo = new long[95];
    static void fibonaci() {
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= 94; ++i) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
    }

    public static void main(String[] args) {
        fibonaci();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(fibo[n]);
        }
        scanner.close();
    }
}
