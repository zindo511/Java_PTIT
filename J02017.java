import java.util.ArrayList;
import java.util.Scanner;

public class J02017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            list.add(scanner.nextInt());
        }

        int i = 0;
        while (i < list.size() - 1) {
            if ((list.get(i) + list.get(i + 1)) % 2 == 0) {
                list.remove(i + 1);
                list.remove(i);
                i = Math.max(0, i - 1);
            }
            else ++i;
        }
        System.out.println(list.size());
        scanner.close();
    }
}
