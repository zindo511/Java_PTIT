import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J03009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            String s1 = scanner.nextLine(),
                    s2 = scanner.nextLine();
            Set<String> se1 = new HashSet<>(),
                    se2 = new HashSet<>();
            String[] parts1 = s1.split(" "),
                    parts2 = s2.split(" ");
            for (String part : parts1)
                se1.add(part);
            for (String part : parts2)
                se2.add(part);

            for (String s : se1) {
                if (!se2.contains(s)){
                    System.out.print(s + " ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}