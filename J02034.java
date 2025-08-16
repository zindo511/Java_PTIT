import java.util.Scanner;

public class J02034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), maxi = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextInt();
            if (a[i] > maxi)
                maxi = a[i];
        }
        int x = 1, check = 1;
        for (int i = 0; i < n; ++i) {
            while (x < a[i] && x <= maxi) {
                System.out.println(x);
                check = 0;
                ++x;
            }
            if (x == a[i]) ++x;
        }
        if (check == 1) System.out.println("Excellent!");
        scanner.close();
    }
}
