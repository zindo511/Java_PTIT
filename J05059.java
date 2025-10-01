import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05059 {
    static String trans(String s) {
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (String part : parts) {
            res.append(part.substring(0, 1).toUpperCase() + part.substring(1) + " ");
        }
        return res.toString();
    }
    static class Student {
        private String studentID, fullName;
        private double bonusPoints, score;

        public Student(String studentID, String fullName, double bonusPoints, double score) {
            this.studentID = studentID;
            this.fullName = fullName;
            this.bonusPoints = bonusPoints;
            this.score = score;
        }
    }

    static String check(double x) {
        if ((int) (x) == x)
            return String.valueOf((int) x);
        return String.valueOf(x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String studentID = scanner.nextLine(),
                    fullName = scanner.nextLine(), areaCode = studentID.substring(0, 3);
            double mathScore = scanner.nextDouble(),
                    physicScore = scanner.nextDouble(),
                    chemistryScore = scanner.nextDouble(), bonusPoints;
            if (areaCode.equals("KV1")) bonusPoints = 0.5;
            else if (areaCode.equals("KV2")) bonusPoints = 1.0;
            else bonusPoints = 2.5;

            double score = mathScore * 2 + physicScore + chemistryScore + bonusPoints;
            students.add(new Student(studentID, trans(fullName), bonusPoints, score));
        }

        int q = scanner.nextInt();
        students.sort(
                Comparator.comparing((Student student) -> student.score, Comparator.reverseOrder())
                        .thenComparing((Student student) -> student.studentID)
        );
        double diemChuan = students.get(q - 1).score;
        System.out.println(diemChuan);
        for (int i = 0; i < students.size(); ++i) {
            Student student = students.get(i);
            System.out.print(student.studentID + " " + student.fullName + " " + check(student.bonusPoints) + " " + check(student.score) + " ");
            if (student.score >= diemChuan) System.out.println("TRUNG TUYEN");
            else System.out.println("TRUOT");
        }
        scanner.close();
    }
}
