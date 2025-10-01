import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class J07055 {
    static String trans(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i)
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1) + " ");
        return res.toString().trim();
    }

    static String rank(double x) {
        if (x >= 8) return "GIOI";
        if (x >= 6.5) return "KHA";
        if (x >= 5) return "TRUNG BINH";
        return "KEM";
    }

    static class Average {
        private String fullName, studentID;
        private double average;

        public Average(String studentID, String fullName, double average) {
            this.studentID = studentID;
            this.fullName = fullName;
            this.average = average;
        }
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("BANGDIEM.in"));
            int n = scanner.nextInt();
            ArrayList<Average> averages = new ArrayList<>();
            for(int i = 1; i <= n; ++i) {
                scanner.nextLine();
                String studentId = "SV" + String.format("%02d", i);
                String fullName = scanner.nextLine();
                double score1 = scanner.nextDouble(),
                        score2 = scanner.nextDouble(),
                        score3 = scanner.nextDouble();
                double average = score1 * 0.25 + score2 * 0.35 + score3 * 0.4;
                averages.add(new Average(studentId, trans(fullName), average));
            }
            averages.sort(
                    Comparator.comparing((Average average) -> average.average, Comparator.reverseOrder())
                            .thenComparing((average -> average.studentID))
            );

            for (int i = 0; i < averages.size(); ++i) {
                Average average = averages.get(i);
                System.out.println(average.studentID + " " + average.fullName + " " + String.format("%.2f", average.average) + " " + rank(average.average));
            }
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
