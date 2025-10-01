import java.util.HashMap;
import java.util.Scanner;

public class J03038 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); ++i)
            count.put(s.charAt(i), 1);
        System.out.println(count.size());
        scanner.close();
    }
}
