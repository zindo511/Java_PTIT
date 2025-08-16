import java.util.Scanner;

public class J03008 {
    static int nt(int n) {
        if (n < 2) return 0;
        for (int i = 2; i * i <= n; ++i){
            if (n % i == 0) return 0;
        }
        return 1;
    }
    static boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            int left = s.charAt(l) - '0', right = s.charAt(r) - '0';
            if (left != right) return false;
            if (nt(left) == 0 || nt(right) == 0) return false;
            ++l; --r;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String s = scanner.nextLine();
            if (check(s)) System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
