import java.util.Scanner;

public class J03024 {
    static String check(String s) {
        int c = 0, l = 0;
        for (int i = 0; i < s.length(); ++i){
            char x = s.charAt(i);
            if (x < '0' || x > '9') return "INVALID";
            if ((x - '0') % 2 == 0) c++;
            else l++;
        }
        if (c > l && (s.length() % 2) == 0) return "YES";
        return "NO";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String s = scanner.nextLine();
            System.out.println(check(s));
        }
        scanner.close();
    }
}
