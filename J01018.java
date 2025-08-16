import java.util.Scanner;

public class J01018 {
    static boolean check(String s){
        int sum = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); ++i) {
            sum += s.charAt(i) - '0';
            if (s.charAt(i) - s.charAt(i - 1) != 2 && s.charAt(i - 1) - s.charAt(i) != 2)
                return false;
        }
        if (sum % 10 != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String n = scanner.nextLine();
            if (check(n)) System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
