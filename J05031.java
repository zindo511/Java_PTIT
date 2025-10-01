import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05031 {
    static class Score {
        private String ma, ten, lop;
        private double d1, d2, d3;

        public Score(String ma, String ten, String lop, double d1, double d2, double d3) {
            this.ma = ma;
            this.ten = ten;
            this.lop = lop;
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
        }
    }

    static BigDecimal trans(double x) {
        BigDecimal b = BigDecimal.valueOf(x);
        return b.setScale(1, RoundingMode.HALF_UP);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Score> scores = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine(),
                    lop = scanner.nextLine();
            double d1 = scanner.nextDouble(),
                    d2 = scanner.nextDouble(),
                    d3 = scanner.nextDouble();
            scores.add(new Score(ma, ten, lop, d1, d2, d3));
        }

        scores.sort(
                Comparator.comparing((Score score) -> score.ten)
        );

        for (int i = 0; i < scores.size(); ++i) {
            Score score = scores.get(i);
            System.out.println((i + 1) + " " + score.ma + " " + score.ten + " " + score.lop + " " +
                    trans(score.d1 ) + " " + trans(score.d2) + " " + trans(score.d3));
        }
        scanner.close();
    }
}
