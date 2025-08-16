import java.util.Scanner;
import java.util.StringTokenizer;

public class J03004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String s = scanner.nextLine();
            String tmp = s.trim().replaceAll("\\s+", " ");

            StringTokenizer st = new StringTokenizer(s);
            StringBuilder result = new StringBuilder();

            while (st.hasMoreTokens()) {
                String w = st.nextToken().toLowerCase();
                result.append(Character.toUpperCase(w.charAt(0)))
                        .append(w.substring(1))
                        .append(" ");
            }
            System.out.println(result.toString().trim());
        }
        scanner.close();
    }
}
