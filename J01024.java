import java.util.Scanner;

public class J01024 {
    static int t;
    static boolean check(String s) {
        for (int i = 0; i < s.length(); ++i){
            int x = s.charAt(i) - '0';
            if (x != 0 && x != 1 && x != 2) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String s = scanner.nextLine();
            if (check(s)) System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
