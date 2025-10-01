import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class practiceb5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> map = new HashMap<>();
        while (t-- > 0) {
            String s = scanner.nextLine().trim().toLowerCase();
            String[] parts = s.split("\\s+");

            StringBuilder sb = new StringBuilder();
            sb.append(parts[parts.length - 1]);
            for (int i = 0; i < parts.length - 1; ++i)
                sb.append(parts[i].charAt(0));

            String full = sb.toString();
            if (!map.containsKey(full)) {
                map.put(full, 1);
            }
            else map.put(full, map.getOrDefault(full, 0) + 1);

            String cnt;
            if (map.get(full) == 1) cnt = "";
            else cnt = String.valueOf(map.get(full));

            System.out.println(full + cnt + "@ptit.edu.vn");
        }
        scanner.close();
    }
}
