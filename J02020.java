import java.util.Scanner;

public class J02020 {
    static int[] a = new int[20];
    static int cnt = 0;
    static void ql(int i, int n, int k) {
        if (i == k + 1) {
            for (int j = 1; j <= k; ++j)
                System.out.print(a[j] + " ");
            ++cnt;
            System.out.println();
        }
        else {
            for (int j = a[i - 1] + 1; j <= n - k + i; ++j) {
                a[i] = j;
                ql(i + 1, n, k);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k;
        n = scanner.nextInt();
        k = scanner.nextInt();
        ql(1, n, k);
        System.out.println("Tong cong co " + cnt + " to hop");
        scanner.close();
    }
}
