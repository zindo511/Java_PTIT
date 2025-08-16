import java.util.Arrays;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;

public class J02005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; ++i)
            a[i] = scanner.nextInt();
        for (int i = 0; i < m; ++i)
            b[i] = scanner.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        Set<Integer> se = new TreeSet<>();

        while (i < n && j < m) {
            if (a[i] == b[j]) {
                se.add(a[i]);
                ++i;
                ++j;
            }
            else if (a[i] < b[j]) ++i;
            else ++j;
        }

        for (Integer x : se)
            System.out.print(x + " ");
        scanner.close();
    }
}
