import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class J05019 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Double> mp1 = new LinkedHashMap<>();
        Map<String, Integer> mp2 = new LinkedHashMap<>();
        Map<String, String> mp3 = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String code = "T" + String.format("%02d", i),
                    name = scanner.nextLine(),
                    begin = scanner.nextLine(),
                    end = scanner.nextLine();
            int total = scanner.nextInt();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date1 = sdf.parse(begin),
                    date2 = sdf.parse(end);
            double hour = (date2.getTime() - date1.getTime()) / 3600000.0;
            if (!mp1.containsKey(name)) {
                mp1.put(name, hour);
            }
            else {
                mp1.put(name, mp1.get(name) + hour);
            }

            if (!mp2.containsKey(name)) {
                mp2.put(name, total);
            }
            else {
                mp2.put(name, mp2.get(name) + total);
            }
            if (!mp3.containsKey(name))
                mp3.put(name, code);
        }
        for (Map.Entry<String, Double> entry : mp1.entrySet()) {
            String key = entry.getKey();
            System.out.println(mp3.get(key) + " " + key + " " + String.format("%.02f", mp2.get(key) / mp1.get(key)));
        }
        scanner.close();
    }
}
