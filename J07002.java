import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07002 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("DATA.in"));
        long sum = 0;
        while (scanner.hasNext()) {
            try {
                String s = scanner.next();
                int val = Integer.parseInt(s);
                sum += val;
            }
            catch (NumberFormatException e) {

            }
        }
        System.out.println(sum);
        scanner.close();
    }
}
