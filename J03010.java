import java.util.HashMap;
import java.util.Scanner;

public class J03010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, Integer> nameCount = new HashMap<>();
        while (t-- > 0) {
            String s = scanner.nextLine();
            s = s.trim().toLowerCase();
            String[] parts = s.split("\\s+");

            StringBuilder result = new StringBuilder();
            result.append(parts[parts.length - 1]);

            for (int i = 0; i < parts.length - 1; ++i){
                result.append(parts[i].charAt(0));
            }

            String res = result.toString();
            if (nameCount.containsKey(res)) {
                int count = nameCount.get(res) + 1;
                nameCount.put(res, count);
                System.out.print(res + count);
            }
            else {
                nameCount.put(res, 1);
                System.out.print(result);
            }
            System.out.println("@ptit.edu.vn");
        }
        scanner.close();
    }
}
