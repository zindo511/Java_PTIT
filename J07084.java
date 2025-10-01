import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class J07084 {
    static int trans(String s) {
        s = s.trim();
        String[] parts = s.split(":");
        int res = Integer.parseInt(parts[0]) * 3600 + Integer.parseInt(parts[1]) * 60 + Integer.parseInt(parts[2]);
        return res / 60;
    }

    static class TimeOnline {
        private String fullName;
        private int time;

        public TimeOnline(String fullName, int time) {
            this.fullName = fullName;
            this.time = time;
        }
        @Override
        public String toString() {
            return fullName + " " + time;
        }
    }

    static String getTen(String s) {
        String[] parts = s.split("\\s+");
        return parts[parts.length - 1];
    }

    static String getHo(String s) {
        String[] parts = s.split("\\s+");
        return parts[0];
    }

    static String getDem(String s) {
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < parts.length - 1; ++i) {
            res.append(parts[i] + " ");
        }
        return res.toString().trim();
    }
    public static void main(String[] args) throws ParseException {
        try {
            Scanner scanner = new Scanner(new File("ONLINE.in"));
            int n = Integer.parseInt(scanner.nextLine());

            ArrayList<TimeOnline> timeOnlines = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (int i = 1; i <= n; ++i) {
                String fullName = scanner.nextLine(),
                        begin = scanner.nextLine(),
                        end = scanner.nextLine();
                Date d1 = sdf.parse(begin),
                        d2 = sdf.parse(end);
                long time = (d2.getTime() - d1.getTime()) / 60000;
                timeOnlines.add(new TimeOnline(fullName, (int) time));
            }
            timeOnlines.sort(
                    Comparator.comparing((TimeOnline time) -> time.time, Comparator.reverseOrder())
                            .thenComparing(time -> time.fullName)
            );
            timeOnlines.forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
