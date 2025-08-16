import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J02006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        Set<Integer>se = new TreeSet<>();
        for (int i = 0; i < n; ++i){
            a[i] = scanner.nextInt();
            se.add(a[i]);
        }
        for (int i = 0; i < m; ++i){
            b[i] = scanner.nextInt();
            se.add(b[i]);
        }
        for (Integer i : se)
            System.out.print(i + " ");
        scanner.close();
    }
}
