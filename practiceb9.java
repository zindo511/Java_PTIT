import java.io.File;
import java.util.Scanner;

public class practiceb9 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("DATA.in"));
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("END")) return;
            s = s.trim().toLowerCase();
            String[] parts = s.split("\\s+");

            StringBuilder sb = new StringBuilder();
            for (String part : parts)
                sb.append(part.substring(0, 1).toUpperCase()).append(part.substring(1)).append(" ");
            System.out.println(sb.toString().trim());
        }
        scanner.close();
    }
}
