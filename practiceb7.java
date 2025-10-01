import java.util.Scanner;

public class practiceb7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt();
        String color = scanner.next();
        if (a > 0 && b > 0) {
            String c = color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();
            System.out.println(((a + b) * 2)  + " " + a * b + " " + c);
        }
        else System.out.println("INVALID");
        scanner.close();
    }
}
