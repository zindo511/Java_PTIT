import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07057 {
    static String trans(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i)
            res.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1) + " ");
        return res.toString().trim();
    }

    static double plus(String people, int addrees) {
        double total = 0;
        if (addrees == 1) total = 1.5;
        else if (addrees == 2) total = 1;
        else total = 0;

        if (people.equals("Kinh")) total += 0;
        else total += 1.5;

        return total;
    }

    static String status(double x) {
        if (x >= 20.5) return "Do";
        return "Truot";
    }

    static class Score {
        private String studentID, status, fullName;
        private double total;

        public Score(String studentID, String fullName, double total, String status) {
            this.studentID = studentID;
            this.fullName = fullName;
            this.total = total;
            this.status = status;
        }

        @Override
        public String toString() {
            return studentID + " " + fullName + " " + String.format("%.1f", total) + " " + status;
        }
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("THISINH.in"));
            int n = scanner.nextInt();

            ArrayList<Score> scores = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                scanner.nextLine();
                String studentID = "TS" + String.format("%02d", i);
                String fullName = trans(scanner.nextLine());
                double score = scanner.nextDouble();
                scanner.nextLine();
                String people = scanner.nextLine();
                int address = scanner.nextInt();
                double total = score + plus(people, address);
                scores.add(new Score(studentID, fullName, total, status(total)));
            }
            scores.sort(
                    Comparator.comparing((Score score) -> score.total, Comparator.reverseOrder())
                            .thenComparing((Score score) -> score.studentID)
            );
            scores.forEach(System.out::println);
            scanner.close();
        }catch (FileNotFoundException e){

        }
    }
}
