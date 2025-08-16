import java.util.Scanner;

public class J02106 {
    static int n, cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; ++i) {
            int cnt1 = 0, cnt0 = 0;
            for (int j = 0; j < 3; ++j) {
                int x = scanner.nextInt();
                if (x == 1) cnt1++;
                else if (x == 0) cnt0++;
            }
            if (cnt1 > cnt0) ++cnt;
        }
        System.out.println(cnt);
        scanner.close();
    }
}
