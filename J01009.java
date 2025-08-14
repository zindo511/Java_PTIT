import java.util.Scanner;

public class J01009 {
    static long gt(int n) {
        long sum = 1;
        for (int i = 1; i <= n; ++i)
            sum *= i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;
        for (int i = 1; i <= n; ++i)
            sum += gt(i);
        System.out.println(sum);
        scanner.close();
    }
}
