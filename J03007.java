import java.util.Scanner;

public class J03007 {
    static boolean check(String s) {
        int l = 0, r = s.length() - 1, sum = 0;
        if ((s.charAt(l) - '0') != 8 || (s.charAt(r) - '0') != 8) return false;
        while (l <= r) {
            int left = s.charAt(l) - '0', right = s.charAt(r) - '0';
            if (left != right) return false;
            if (l != r) sum = sum + left + right;
            else sum += left;
            ++l; --r;
        }
        if (sum % 10 == 0) return true;
        return false;
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
