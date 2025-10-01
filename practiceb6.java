import java.util.Scanner;

public class practiceb6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            double ax = scanner.nextDouble(), ay = scanner.nextDouble(), bx = scanner.nextDouble(), by = scanner.nextDouble();
            double kc = Math.sqrt((bx - ax) * (bx - ax) + (by - ay) * (by - ay));
            System.out.printf("%.04f%n", kc);
        }
        scanner.close();
    }
}
