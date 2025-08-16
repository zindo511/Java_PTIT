import java.util.Scanner;

public class J01008 {
    static void nt(int n) {
        for (int i = 2; i * i <= n; ++i) {
            int cnt = 0;
            if (n % i == 0) {
                while (n % i == 0) {
                    ++cnt;
                    n /= i;
                }
                System.out.print(i + "(" + cnt + ") ");
            }
        }
        if (n > 1) System.out.print(n + "(" + "1)");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i){
            int n = scanner.nextInt();
            System.out.print("Test " + i + ": ");
            nt(n);
            System.out.println();
        }
        scanner.close();
    }
}
