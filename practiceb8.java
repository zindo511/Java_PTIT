import java.io.File;
import java.util.Scanner;

public class practiceb8 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("DATA.in"));
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(s);
        }
        scanner.close();
    }
}
