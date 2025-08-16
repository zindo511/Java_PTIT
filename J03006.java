import java.util.Scanner;

public class J03006 {
    static boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r){
            int left = s.charAt(l) - '0', right = s.charAt(r) - '0';
            if (left % 2 != 0 || right % 2 != 0) return false;
            if (left != right) return false;
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
