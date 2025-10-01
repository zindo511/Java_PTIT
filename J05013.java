import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05013 {
    static double check(double x) {
        if (x > 10) return x / 10;
        return x;
    }
    static String Aver(double x) {
        if (x >= 9.5) return "XUAT SAC";
        if (x >= 8) return "DAT";
        if (x >= 5) return "CAN NHAC";
        return "TRUOT";
    }
    static class Recruitment {
        private String studentCode, studentName, rank;
        private double average;
        public Recruitment(String studentCode, String studentName, double average, String rank) {
            this.studentCode = studentCode;
            this.studentName = studentName;
            this.average = average;
            this.rank = rank;
        }
        public double getAverage() {
            return average;
        }
        public String toString(){
            return studentCode + " " + studentName + " " + String.format("%.02f", average) + " " + rank;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Recruitment> recruitments = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String studentCode = "TS" + String.format("%02d", i);
            String studentName = scanner.nextLine();
            double theoryScore = check(scanner.nextDouble()),
                    practiceScore = check(scanner.nextDouble());
            double average = (theoryScore +  practiceScore) / 2;
            String rank = Aver(average);
            recruitments.add(new Recruitment(studentCode, studentName, average, rank));
        }
        recruitments.sort(
                Comparator.comparing(Recruitment::getAverage, Comparator.reverseOrder())
        );
        recruitments.forEach(System.out::println);
        scanner.close();
    }
}
