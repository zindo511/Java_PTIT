import java.util.Scanner;

public class J01014 {
    static boolean check(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }
    static long nt(long n) {
        for (int i = (int) Math.sqrt(n); i >= 1; --i) {
            if (n % i == 0){
                if(check(n / i)) return n / i;
                if (check(i)) return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            System.out.println(nt(n));
        }
        scanner.close();
    }
}
