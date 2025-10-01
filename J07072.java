import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07072 {
    static String trans(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i)
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1) + " ");
        return res.toString().trim();
    }
    static String getTen(String s) {
        String[] parts = s.split("\\s+");
        return parts[parts.length - 1];
    }

    static String getHo(String s) {
        String[] parts = s.split("\\s+");
        return parts[0];
    }

    static String getDem(String s) {
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < parts.length - 1; ++i) {
            res.append(parts[i] + " ");
        }
        return res.toString().trim();
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("DANHSACH.in"));
            ArrayList<String> names = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                names.add(trans(s.trim().toLowerCase()));
            }
            names.sort(
                    Comparator.comparing((String name) -> getTen(name))
                            .thenComparing((String name) -> getHo(name))
                            .thenComparing((String name) -> getDem(name))
            );
            for (int i = 0; i < names.size(); ++i)
                System.out.println(names.get(i));
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
