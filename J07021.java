import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07021 {
    static String trans(String s) {
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < parts.length; ++i) {
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1).toLowerCase());
            res.append(" ");
        }
        return res.toString();
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("DATA.in"));
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (s.equals("END")) break;
                s = s.trim().toLowerCase();
                System.out.println(trans(s));
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {

        }
    }

}
