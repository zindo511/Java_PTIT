import java.util.Scanner;

public class J01017 {
    static boolean check(String s){
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) - s.charAt(i - 1) != 1 && s.charAt(i - 1) - s.charAt(i) != 1)
                return false;
        }
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
