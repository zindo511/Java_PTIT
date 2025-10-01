import java.util.Scanner;

public class J03032 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            String s = scanner.nextLine();
            String[] parts = s.split("\\s+");
            for (int i = 0; i < parts.length; ++i){
                for (int j = parts[i].length() - 1; j >= 0; --j){
                    System.out.print(parts[i].charAt(j));
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
