import java.util.Scanner;

public class J02105 {
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; ++i){
            System.out.print("List(" + (i + 1) + ") = ");
            for (int j = 0; j < n; ++j){
                int x = scanner.nextInt();
                if (x == 1) System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
