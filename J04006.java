import java.util.Scanner;

public class J04006 {
    static class Student {
        private String name, lop, birthday;
        private double gpa;

        public Student(String name, String lop, String birthday, double gpa) {
            this.name = name;
            this.lop = lop;
            this.birthday = birthday;
            this.gpa = gpa;
        }

        public void info() {
            String[] parts = birthday.split("/");

//            int d = Integer.parseInt(parts[0]),
//                    m = Integer.parseInt(parts[1]),
//                    y = Integer.parseInt(parts[2]);
//
//            birthday = String.format("%02d/%02d/%04d", d, m, y);
            if (parts[0].length() == 1) parts[0] = "0" + parts[0];
            if (parts[1].length() == 1) parts[1] = "0" + parts[1];
            birthday = parts[0] + "/" + parts[1] + "/" + parts[2];
            System.out.println("B20DCCN001 " + name + " " + lop + " " + birthday + " " + String.format("%.2f", gpa));
        }
    }
    public static void main(String[] args) {
        String name, lop, birthday;
        double gpa;

        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        lop = scanner.nextLine();
        birthday = scanner.nextLine();
        gpa = scanner.nextDouble();

        Student student = new Student(name, lop, birthday, gpa);
        student.info();
        scanner.close();
    }
}
