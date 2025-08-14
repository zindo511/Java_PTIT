import java.util.Scanner;

public class J01026 {
    static boolean huy(int n) {
        int x = (int) Math.sqrt(n);
        if (x * x == n) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            if (huy(n)) System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
