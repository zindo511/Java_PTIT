import java.util.Map;
import java.util.Scanner;

public class J04018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int a = scanner.nextInt(),
                    b = scanner.nextInt(),
                    c = scanner.nextInt(),
                    d = scanner.nextInt();

            int a1 = a * a + a * c - b * b - b * d, b1 = 2 * a * b + b * c + a * d, c1 = a * a + 2 * a * c + c * c - b * b - 2 * b * d - d * d,
                    d1 = 2 * a * b + 2 * a * d + 2 * c * b + 2 * c * d;
            System.out.print(a1);
            if (b1 < 0) System.out.print(" - ");
            else System.out.print(" + ");
            System.out.print(Math.abs(b1) + "i, " + c1);
            if (d1 < 0) System.out.print(" - ");
            else System.out.print(" + ");
            System.out.println(Math.abs(d1) + "i");
        }
        scanner.close();
    }
}
