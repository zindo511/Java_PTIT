import java.util.*;

public class J03020 {
    static boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            ++l; --r;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxi = 0;
        Map<String, Integer> map = new LinkedHashMap<>();

        while (scanner.hasNext()) {
            String s = scanner.next();
            if (check(s)) {
                if (!map.containsKey(s)) map.put(s, 1);
                else map.put(s, map.get(s) + 1);
            }

        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.length() > maxi) {
                maxi = key.length();
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().length() == maxi)
                System.out.println(entry.getKey() + " " + entry.getValue());
        }
        scanner.close();
    }
}
