import java.util.ArrayList;
import java.util.Scanner;

public class J05069 {
    static class Football {
        private String ma, ten;
        private int giaVe;

        public Football(String ma, String ten, int giaVe) {
            this.ma = ma;
            this.ten = ten;
            this.giaVe = giaVe;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Football> footballs = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine();
            int giaVe = scanner.nextInt();
            footballs.add(new Football(ma, ten, giaVe));
        }

        int q = scanner.nextInt();
        scanner.nextLine();
        while (q-- > 0) {
            String s = scanner.next();
            int cdv = scanner.nextInt();
            String ma = s.substring(1, 3);
            for (int i = 0; i < footballs.size(); ++i) {
                Football football = footballs.get(i);
                if (football.ma.equals(ma)){
                    System.out.println(s + " " + football.ten + " " + football.giaVe * cdv);
                }
            }
        }
        scanner.close();
    }
}
