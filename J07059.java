import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class J07059 {
    static class Exam {
        private String code, day, hour, room;
        private Date dateTime;
        public Exam(String code, String day, String hour, String room) throws ParseException {
            this.code = code;
            this.day = day;
            this.hour = hour;
            this.room = room;
            this.dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(day + " " + hour);
        }

        public Date getDateTime() {
            return dateTime;
        }

        public String getCode() {
            return code;
        }
        @Override
        public String toString() {
            return code + " " + day + " " + hour + " " + room;
        }
    }


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("CATHI.in"));
            int n = Integer.parseInt(scanner.nextLine());
            ArrayList<Exam> exams = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                String code = "C" + String.format("%03d", i),
                        day = scanner.nextLine(),
                        hour = scanner.nextLine(),
                        room = scanner.nextLine();
                exams.add(new Exam(code, day, hour, room));
            }
            exams.sort(
                    Comparator.comparing(Exam::getDateTime)
                            .thenComparing(Exam::getCode)
            );
            exams.forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException | ParseException e) {

        }
    }
}
