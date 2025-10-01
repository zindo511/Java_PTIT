import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07071 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("DANHSACH.in"));
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; ++i){
            list.add(scanner.nextLine());
        }

        list.sort(
                Comparator.comparing(J07071::getFirstName)
                        .thenComparing(J07071::getLastName)
        );
        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            String s = scanner.nextLine();
            for (String name : list) {
                if (trans(name).length() == s.length()) {
                    if (check(trans(name), s)) System.out.println(name);
                }
            }
        }
        scanner.close();
    }

    static String trans(String name) {
        name = name.toUpperCase();
        String[] parts = name.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; ++i){
            sb.append(parts[i].charAt(0));
            if (i != parts.length - 1) sb.append(".");
        }
        return sb.toString().trim();
    }

    static boolean check(String s, String x) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) != x.charAt(i)) ++cnt;
        return cnt <= 1;
    }
    static String getFirstName(String name) {
        String[] parts = name.split(" ");
        return parts[parts.length - 1];
    }

    static String getLastName(String name) {
        String[] parts = name.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length - 1; ++i)
            sb.append(parts[i]);
        return sb.toString();
    }
}
