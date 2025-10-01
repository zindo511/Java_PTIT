import java.util.Scanner;

public class J03022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().toLowerCase();
            res.append(s);
        }
        for (int i = 0; i < res.length(); ++i) {
            char c = res.charAt(i);
            if (c == '.' || c == '?' || c == '!') {
                res.replace(i, i + 1, "#");
            }
        }
//        System.out.println(res);
        String[] parts1 = res.toString().split("#");
        for (String s : parts1) {
            String[] parts = s.trim().split("\\s+");
            for (int i = 0; i < parts.length; ++i) {
                if (i == 0) parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
                System.out.print(parts[i] + " ");
            }
            System.out.println();
//            System.out.println(s);
        }
        scanner.close();
    }
}
