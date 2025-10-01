import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05011 {
    static int cal(String s) {
        String[] parts = s.split(":");
        int gio = Integer.valueOf(parts[0]),
                phut = Integer.valueOf(parts[1]);

        return gio * 60 + phut;
    }

    static String trans(int x) {
        int gio = x / 60,
                phut = x % 60;
        return gio + " gio " + phut + " phut ";
    }
    static class Hour {
        private String ma, ten, vao, ra;

        public Hour(String ma, String ten, String vao, String ra) {
            this.ma = ma;
            this.ten = ten;
            this.vao = vao;
            this.ra = ra;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + trans(cal(ra) - cal(vao));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Hour> hours = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            String ma = scanner.nextLine(),
                    ten = scanner.nextLine(),
                    vao = scanner.nextLine(),
                    ra = scanner.nextLine();
            hours.add(new Hour(ma, ten, vao, ra));
        }

        hours.sort(
                Comparator.comparing((Hour hour) -> (cal(hour.ra) - cal(hour.vao)), Comparator.reverseOrder())
        );

        hours.forEach(System.out::println);
        scanner.close();
    }
}
