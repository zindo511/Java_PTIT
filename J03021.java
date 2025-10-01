import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J03021 {
    static boolean tn(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r){
            if (s.charAt(l) != s.charAt(r))
                return false;
            ++l;
            --r;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "ABC");
        map.put(3, "DEF");
        map.put(4, "GHI");
        map.put(5, "JKL");
        map.put(6, "MNO");
        map.put(7, "PQRS");
        map.put(8, "TUV");
        map.put(9, "WXYZ");
        for (int i = 1; i <= n; ++i) {
            String s = scanner.nextLine().toUpperCase();
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < s.length(); ++j) {
                char x = s.charAt(j);
                for (Map.Entry<Integer, String> entry : map.entrySet()){
                    int y = entry.getKey();
                    String z = entry.getValue();
                    if (z.contains(String.valueOf(x))) {
                        res.append(y);
                        break;
                    }
                }
            }
            if (tn(res.toString())) System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
