import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05009 {
    static class Exam {
        private String ten, ns;
        private double d1, d2, d3;
        int ma;

        public Exam(int ma, String ten, String ns, double d1, double d2, double d3){
            this.ma = ma;
            this.ten = ten;
            this.ns = ns;
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Exam> exams = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String ten = scanner.nextLine(),
                    ns = scanner.nextLine();
            double d1 = scanner.nextDouble(),
                    d2 = scanner.nextDouble(),
                    d3 = scanner.nextDouble();
            exams.add(new Exam(i, ten, ns, d1, d2, d3));
        }

        exams.sort(
                Comparator.comparing((Exam exam) -> (exam.d1 + exam.d2 + exam.d3))
        );

        Exam e = exams.get(t - 1);
        double max1 = e.d1 + e.d2 + e.d3;
        for (int i = 0; i < exams.size(); ++i) {
            Exam exam = exams.get(i);
            double sum = exam.d1 + exam.d2 + exam.d3;
            if (sum == max1) System.out.println(exam.ma + " " + exam.ten + " " + exam.ns + " " + sum);
        }
        scanner.close();
    }
}
