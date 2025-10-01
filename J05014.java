import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05014 {
    static String transSubject(String s) {
        String x = s.substring(0, 1);
        if (x.equals("A")) return "TOAN";
        if (x.equals("B")) return "LY";
        return "HOA";
    }
    static double trans(String s) {
        String x = s.substring(1);
        if (x.equals("1")) return 2.0;
        if (x.equals("2")) return 1.5;
        if (x.equals("3")) return 1.0;
        return 0.0;
    }
    static class Recruiment{
        private String teacherCode, teacherName, subject, rank;
        private double total;
        public Recruiment(String teacherCode, String teacherName, String subject, double total, String rank) {
            this.teacherCode = teacherCode;
            this.teacherName = teacherName;
            this.subject = subject;
            this.total = total;
            this.rank = rank;
        }
        public double getTotal(){
            return total;
        }
        public String toString() {
            return teacherCode + " " + teacherName + " " + subject + " " + String.format("%.01f", total) + " " + rank;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Recruiment> recruiments = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String teacherCode = "GV" + String.format("%02d", i),
                    teacherName = scanner.nextLine(),
                    code = scanner.nextLine();
            double tinScore = scanner.nextDouble(),
                    chuyenScore = scanner.nextDouble();
            String subject = transSubject(code);
            double uuTien = trans(code);
            double total = tinScore * 2 + chuyenScore + uuTien;
            String rank;
            if (total >= 18) rank = "TRUNG TUYEN";
            else rank = "LOAI";
            recruiments.add(new Recruiment(teacherCode, teacherName, subject, total, rank));
        }
        recruiments.sort(
                Comparator.comparing(Recruiment::getTotal, Comparator.reverseOrder())
        );
        recruiments.forEach(System.out::println);
        scanner.close();
    }
}
