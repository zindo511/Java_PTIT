import java.util.*;

public class J05062 {
    static class Student {
        private String fullName;
        private double tbc;

        public Student(String fullName, double tbc){
            this.fullName = fullName;
            this.tbc = tbc;
        }
        public double getTbc() {
            return tbc;
        }
    }
    static class Scholarship {
        private double tbc;
        private int drl;

        public Scholarship(double tbc, int drl) {
            this.tbc = tbc;
            this.drl = drl;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        ArrayList<Student> students = new ArrayList<>();
        Map<String, Scholarship> mp1 = new LinkedHashMap<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String fullName = scanner.nextLine();
            double tbc = scanner.nextDouble();
            int drl = scanner.nextInt();
            students.add(new Student(fullName, tbc));
            Scholarship scholarship = new Scholarship(tbc, drl);
            mp1.put(fullName, scholarship);
        }
        students.sort(
                Comparator.comparing(Student::getTbc, Comparator.reverseOrder())
        );

        double mini = students.get(Math.min(m, students.size()) - 1).tbc;
        Map<String, Boolean> mp2 = new HashMap<>();

        for (Student student : students) {
            if (student.tbc >= mini)
                mp2.put(student.fullName, true);
            else mp2.put(student.fullName, false);
        }
        for (Map.Entry<String, Scholarship> entry : mp1.entrySet()) {
            String key = entry.getKey();
            Scholarship value = entry.getValue();
            if (mp2.get(key)) {
                if (value.tbc >= 3.6 && value.drl >= 90)
                    System.out.println(key + ": " + "XUATSAC");
                else if (value.tbc >= 3.2 && value.drl >= 80)
                    System.out.println(key + ": " + "GIOI");
                else if (value.tbc >= 2.5 && value.drl >= 70)
                    System.out.println(key + ": " + "KHA");
                else
                    System.out.println(key + ": " + "KHONG");
            }
            else System.out.println(key + ": " + "KHONG");
        }
        scanner.close();
    }
}
