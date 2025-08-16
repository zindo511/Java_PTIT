import java.util.Scanner;

public class J01016 {
    static boolean check(long n) {
        String s = n + "";
        int cnt4 = 0, cnt7 = 0;
        for (char i : s.toCharArray()){
            if (i == '4') cnt4++;
            else if (i == '7') cnt7++;
        }
        if (cnt4 + cnt7 == 4 || cnt4 + cnt7 == 7) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if (check(n)) System.out.println("YES");
        else System.out.println("NO");
        scanner.close();
    }
}
