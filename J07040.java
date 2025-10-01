import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class J07040 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        ArrayList<String> list = (ArrayList<String>) ois.readObject();
        ois.close();

        Set<String> se = new HashSet<>();
        for (String line : list) {
            String[] words = line.toLowerCase().split("\\W+");
            for (String w : words){
                if (!w.isEmpty()) se.add(w);
            }
        }

        Scanner scanner = new Scanner(new File("VANBAN.in"));
        LinkedHashSet<String> res = new LinkedHashSet<>();
        while (scanner.hasNextLine()) {
            String[] words = scanner.nextLine().toLowerCase().split("\\W+");
            for (String w : words) {
                if (!w.isEmpty() && se.contains(w)) {
                    res.add(w);
                }
            }
        }
        scanner.close();

        for (String w : res)
            System.out.println(w);
    }
}
