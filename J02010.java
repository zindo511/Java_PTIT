import java.util.Scanner;

public class J02010 {
    static int n;
    static int[] a = new int[105];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; ++i)
            a[i] = scanner.nextInt();
        for (int i = 0; i < n - 1; ++i){
            System.out.print("Buoc " + (i + 1) + ": ");
            for (int j = i + 1; j < n; ++j){
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            for (int j = 0; j < n; ++j)
                System.out.print(a[j] + " ");
            System.out.println();
        }
        scanner.close();
    }
}
