import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class J05015 {
    static String trans(String s) {
        StringBuilder res = new StringBuilder();
        s = s.trim();
        String[] parts = s.split("\\s+");
        for (int i = 0; i < parts.length; ++i) {
            res.append(parts[i].charAt(0));
        }
        return res.toString().trim();
    }
    static class Race {
        private String code, fullName, unit;
        private long v;
        public Race(String code, String fullName, String unit, long v) {
            this.code = code;
            this.fullName = fullName;
            this.unit = unit;
            this.v = v;
        }
        public long getV(){
            return v;
        }
        public String toString(){
            return code + " " + fullName + " " + unit + " " + v + " Km/h";
        }
    }
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Race> races = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            String fullName = scanner.nextLine(),
                    unit = scanner.nextLine(),
                    end = scanner.nextLine();
            String code = trans(unit) + trans(fullName);
            String begin = "6:00";
            SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
            Date date1 = sdf.parse(begin),
                    date2 = sdf.parse(end);
            double hour = (date2.getTime() - date1.getTime()) / 3600000.0;
            long v = Math.round (120.0 / hour) ;
            races.add(new Race(code, fullName, unit, v));
        }
        races.sort(
                Comparator.comparing(Race::getV, Comparator.reverseOrder())
        );
        races.forEach(System.out::println);
        scanner.close();
    }
}
