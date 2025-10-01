import java.util.Scanner;

public class J02103 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, n, m;
        t = scanner.nextInt();
        for (int x = 1; x <= t; ++x){
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[][] a = new int[n][m],
                    b = new int[m][n],
                    res = new int[n][n];

            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    a[i][j] = scanner.nextInt();

            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j)
                    b[i][j] = a[j][i];

            for (int i = 0; i < n; ++i){
                for (int k = 0; k < m; ++k){
                    for (int j = 0; j < n; ++j){
                        res[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            System.out.println("Test " + x + ":");
            for (int i = 0; i < n; ++i){
                for (int j = 0; j < n; ++j){
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}
