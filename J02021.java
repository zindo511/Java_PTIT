import java.util.Scanner;

public class J02021 {
    static int n, k, cnt = 0;
    static int[] a = new int[20];
    static void ql(int i) {
        if (i == k + 1){
            for (int j = 1; j <= k; ++j)
                System.out.print(a[j]);
            System.out.print(" ");
            ++cnt;
            return;
        }
        for (int j = a[i - 1] + 1; j <= n - k + i; ++j){
            a[i] = j;
            ql(i + 1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        ql(1);
        System.out.println();
        System.out.println("Tong cong co " + cnt + " to hop");
        scanner.close();
    }
}
