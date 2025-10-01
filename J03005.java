import java.util.Scanner;

public class J03005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String s = scanner.nextLine();
            s = s.trim().toLowerCase();
            String[] parts = s.split("\\s+");
            for (int i = 0; i < parts.length; ++i) {
                parts[i] = Character.toUpperCase(parts[i].charAt(0)) + parts[i].substring(1);
            }
            for (int i = 1; i < parts.length; ++i){
                System.out.print(parts[i]);
                if (i != parts.length - 1) System.out.print(" ");
                else System.out.print(", ");
            }
            System.out.println(parts[0].toUpperCase());
        }
        scanner.close();
}
}