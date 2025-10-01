import java.util.Scanner;

public class J02014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int[] a = new int[n],
                    pre = new int[n];
            for (int i = 0; i < n; ++i)
                a[i] = scanner.nextInt();
            pre[0] = a[0];
            for (int i = 1; i < n; ++i)
                pre[i] = pre[i - 1] + a[i];

            int check = -1;
            for (int i = 1; i < n; ++i){
                if (pre[i - 1] == pre[n - 1] - pre[i]) {
                    check = i;
                    break;
                }
            }
            if (check != -1) check += 1;
            System.out.println(check);

        }
        scanner.close();
    }
}
