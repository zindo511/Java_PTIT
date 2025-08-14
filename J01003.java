import java.util.Scanner;

public class J01003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b;
        a = scanner.nextDouble();
        b = scanner.nextDouble();

        if (a == 0 && b != 0) System.out.println("VN");
        else if (a == 0 && b == 0) System.out.println("VSN");
        else System.out.printf("%.2f%n", -b / a);
        scanner.close();
    }
}
