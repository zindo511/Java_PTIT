import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J05074 {
    static class Attendance {
        private String ma, ten, lop;
        private int grade;

        public Attendance(String ma, String ten, String lop, int grade) {
            this.ma = ma;
            this.ten = ten;
            this.lop = lop;
            this.grade = grade;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine();
        Map<String, Attendance> map = new HashMap<>();
        ArrayList<String> attendances = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine(),
                    lop = scanner.nextLine();
            map.put(ma, new Attendance(ma, ten, lop, 10));
            attendances.add(ma);
        }


        for (int i = 1; i <= n; ++i) {
            String ma = scanner.next(),
                    s = scanner.next();

            Attendance attendance = map.get(ma);
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == 'v') attendance.grade -= 2;
                else if (s.charAt(j) == 'm') attendance.grade -= 1;
            }
            if (attendance.grade < 0) attendance.grade = 0;
            map.put(ma, new Attendance(ma, attendance.ten, attendance.lop, attendance.grade));
        }

        for (int i = 0; i < attendances.size(); ++i) {
            Attendance attendance = map.get(attendances.get(i));
            System.out.print(attendance.ma + " " + attendance.ten + " " + attendance.lop + " " + attendance.grade);
            if (attendance.grade == 0) System.out.println(" KDDK");
            else System.out.println();
        }
        scanner.close();
    }
}
