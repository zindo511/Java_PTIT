import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class J07003 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("DATA.in"));
        String s = scanner.nextLine();
        while (s.length() != 1){
            String s1 = s.substring(0, s.length() / 2),
                    s2 = s.substring(s.length() / 2);
            BigInteger x1 = new BigInteger(s1),
                    x2 = new BigInteger(s2);
            s = x1.add(x2).toString();
            System.out.println(s);
        }
        scanner.close();
    }
}
