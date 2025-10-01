import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07022 {
    public static void main(String[] args) {
        try {
            ArrayList<String> strings = new ArrayList<>();
            Scanner scanner = new Scanner(new File("DATA.in"));
            while (scanner.hasNext()) {
                String s = scanner.next();
                try {
                    Integer.parseInt(s);
                }
                catch (NumberFormatException e) {
                    strings.add(s);
                }
            }
            strings.sort(
                    Comparator.comparing((String s) -> s)
            );
            for (String s : strings)
                System.out.print(s + " ");
            scanner.close();
        }catch (FileNotFoundException e) {

        }
    }
}
