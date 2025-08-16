import java.util.Scanner;

public class J02104 {
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0;  i < n; ++i){
            for (int j = 0; j < n; ++j){
                int x = scanner.nextInt();
                if (x == 1 && i < j) System.out.println("(" + (i + 1) + "," + (j + 1) + ")");
            }
        }
        scanner.close();
    }
}

