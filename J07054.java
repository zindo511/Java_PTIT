import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class J07054 {
    static String trans(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i)
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1) + " ");
        return res.toString().trim();
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
                double average = (score1 * 3 + score2 * 3 + score3 * 2) / 8;
                averages.add(new Average(studentId, trans(fullName), average));
            }
            averages.sort(
                    Comparator.comparing((Average average) -> average.average, Comparator.reverseOrder())
                            .thenComparing((average -> average.studentID))
            );

            Map<Double, Integer> map = new HashMap<>();
            int rank = 1;
            for (int i = 0; i < averages.size(); ++i) {
                Average average = averages.get(i);
                if (!map.containsKey(average.average)){
                    map.put(average.average, rank);
                }
                rank++;
            }
            for (int i = 0; i < averages.size(); ++i) {
                Average average = averages.get(i);
                System.out.println(average.studentID + " " + average.fullName + " " + String.format("%.2f", average.average) + " " + map.get(average.average));
            }
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
