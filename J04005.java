import java.util.Scanner;

public class J04005 {
    static class Student {
        private String name, birthday;
        private double d1, d2, d3;

        public Student(String name, String birthday, double d1, double d2, double d3) {
            this.name = name;
            this.birthday = birthday;
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
        }

        public void info() {
            System.out.println(name + " " + birthday + " " + String.format("%.1f", d1 + d2 + d3));
        }
    }
    public static void main(String[] args) {
        String name, birthday;
        double d1, d2, d3;

        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        birthday = scanner.nextLine();
        d1 = scanner.nextDouble();
        d2 = scanner.nextDouble();
        d3 = scanner.nextDouble();

        Student student = new Student(name, birthday, d1, d2, d3);
        student.info();
        scanner.close();
    }
}
