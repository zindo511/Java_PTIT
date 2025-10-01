import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class J05018 {
    static class Student {
        private String ten, ma;
        private BigDecimal dtb;

        public Student(String ma, String ten, BigDecimal dtb) {
            this.ma = ma;
            this.ten = ten;
            this.dtb = dtb;
        }
        static String trans(BigDecimal val) {
            double dtb = val.doubleValue();
            if (dtb >= 9) return "XUAT SAC";
            if (dtb >= 8) return "GIOI";
            if (dtb >= 7) return "KHA";
            if (dtb >= 5) return "TB";
            return "YEU";
        }

        @Override
        public String toString() {
            return "HS" + ma + " " + ten + " " + dtb + " " + trans(dtb);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            String ten = scanner.nextLine();
            BigDecimal total = BigDecimal.ZERO;
            for (int j = 1; j <= 10; ++j){
                BigDecimal d = scanner.nextBigDecimal();
                if (j <= 2) total = total.add(d.multiply(BigDecimal.valueOf(2)));
                else total = total.add(d);
            }
            scanner.nextLine();
            BigDecimal dtb = total.divide(BigDecimal.valueOf(12), 1, RoundingMode.HALF_UP);

            String ma = String.valueOf(i);
            while (ma.length() < 2) ma = "0" + ma;
            students.add(new Student(ma, ten, dtb));
        }

        students.sort(
                Comparator.comparing((Student student) -> student.dtb, Comparator.reverseOrder())
                        .thenComparing((Student student) -> student.ma)
        );
        students.forEach(System.out::println);
        scanner.close();
    }
}

