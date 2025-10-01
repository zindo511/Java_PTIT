import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class J07007 {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        try {
            Scanner scanner = new Scanner(new File("VANBAN.in"));
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().toLowerCase();
                String[] parts = s.split(" ");
                for (String part : parts) map.put(part, map.getOrDefault(part, 0) + 1);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey());
    }
}
