import java.util.Scanner;

public class J02013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = scanner.nextInt();
        for (int i = 0; i < n - 1; ++i) {
            int check = 0;
            for (int j = 0; j < n - i - 1; ++j){
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    check = 1;
                }
            }
            if (check == 1) {
                System.out.print("Buoc " + (i + 1) + ": ");
                for (int j = 0; j < n; ++j)
                    System.out.print(a[j] + " ");
                System.out.println();
            }

        }
    }
}
