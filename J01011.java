import java.util.Scanner;

public class J01011 {
    static long ucln(long a, long b) {
        while (b != 0) {
            long temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long a, b;
            a = scanner.nextLong();
            b = scanner.nextLong();

            long uc = ucln(a, b);
            long bc = a * b / uc;

            System.out.print(bc + " " + uc);
            System.out.println();
        }
        scanner.close();
    }
}

/*
(a, b) = (b, a % b)
 */
