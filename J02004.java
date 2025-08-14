import java.util.Scanner;

public class J02004 {
    static boolean check(int[] a, int n){
        int l = 0, r = n - 1;
        while (l <= r) {
            if(a[l] != a[r]) return false;
            ++l; --r;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i)
                arr[i] = scanner.nextInt();
            if (check(arr, n)) System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
