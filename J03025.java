import java.util.Scanner;

public class J03025 {
    static boolean check(String s) {
        int l = 0, r = s.length() - 1, cnt = 0;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) cnt++;
            ++l;
            --r;
        }
        // nếu độ dài lẻ, cnt = 0, sửa thằng ở giữa bất kì cái gì nó cũng đối xứng
        return cnt == 1 || (cnt == 0 && s.length() % 2 == 1);
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
