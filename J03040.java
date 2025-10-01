import java.util.Scanner;

public class J03040 {
    static boolean condition1(String s){
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) <= s.charAt(i - 1))
                return false;
        }
        return true;
    }
    static boolean condition2(String s) {
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) != s.charAt(i - 1))
                return false;
        }
        return true;
    }
    static boolean condition3(String s) {
        String s1 = s.substring(0, 3),
                s2 = s.substring(3);
        return condition2(s1) && condition2(s2);
    }
    static boolean condition4(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != '6' && s.charAt(i) != '8')
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; ++i) {
            String s = scanner.nextLine();
            String s_n = s.substring(5, 8) + s.substring(9);
            if (condition1(s_n) || condition2(s_n) || condition3(s_n) || condition4(s_n))
                System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
