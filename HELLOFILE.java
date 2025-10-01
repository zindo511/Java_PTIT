import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HELLOFILE {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(new File("Hello.txt"));
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                System.out.println(s);
            }
            scanner.close();
        }catch (FileNotFoundException e) {

        }
    }
}
