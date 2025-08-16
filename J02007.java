import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class J02007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int j = 1; j <= t; ++j){
            int n = scanner.nextInt();
            LinkedHashMap<Integer, Integer> map= new LinkedHashMap<>();

            for (int i = 0; i < n; ++i){
                int x = scanner.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            System.out.println("Test " + j + ":");
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " xuat hien " + entry.getValue() + " lan");
            }
        }
        scanner.close();
    }
}
