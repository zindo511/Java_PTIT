import java.util.Scanner;

public class J01013 {
    static long huy(int n) {
        long sum = 0;
        for(int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                sum += i;
                n /= i;
            }
        }
        if (n > 1) sum += n;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long sum = 0;
        while (t-- > 0) {
            int n = scanner.nextInt();
            sum += huy(n);
        }
        System.out.println(sum);
        scanner.close();
    }
}
