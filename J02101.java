import java.util.Scanner;

public class J02101 {
    static int t, n;
    static int[][] a = new int[105][105];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    a[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; ++i){
                if (i % 2 == 0) {
                    for (int j = 0; j < n; ++j)
                        System.out.print(a[i][j] + " ");
                }
                else
                    for (int j = n - 1; j >= 0; --j)
                        System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
