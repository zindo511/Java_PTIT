import java.util.Scanner;

public class J01012 {
    static int huy(int n) {
        int cnt = 0;
        for (int i = 1; i * i <= n; ++i) {
            if(n % i == 0) {
                if (i % 2 == 0) ++cnt;
                if(i == n / i) continue;
                if((n / i) % 2 == 0) ++cnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while(t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(huy(n));
        }
        scanner.close();
    }
}
