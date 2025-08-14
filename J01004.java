import java.util.Scanner;

public class J01004 {
    static boolean nt(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; ++i){
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            if (nt(n)) System.out.println("YES");
            else System.out.println("NO");
        }

        scanner.close();
    }
}
