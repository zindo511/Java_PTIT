import java.util.Scanner;

public class J02012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = scanner.nextInt();
        for (int i = 0; i < n; ++i){
            System.out.print("Buoc " + i + ": ");
            for (int j = 0; j < i; ++j){
                if (a[i] < a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            for (int j = 0; j <= i; ++j)
                System.out.print(a[j] + " ");
            System.out.println();
        }
    }
}
