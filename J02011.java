import java.util.Scanner;

public class J02011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = scanner.nextInt();
        for (int i = 0; i < n - 1; ++i){
            System.out.print("Buoc " + (i + 1) + ": ");
            int minIndex = i;
            for (int j = i + 1; j < n; ++j){
                if (a[minIndex] > a[j]) minIndex = j;
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;

            for (int j = 0; j < n; ++j)
                System.out.print(a[j] + " ");
            System.out.println();
        }
        scanner.close();
    }
}
