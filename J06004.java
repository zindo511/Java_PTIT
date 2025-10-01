import java.util.*;

public class J06004 {
    static class Manage {
        private String studentCode, studentName, phoneNumber;
        private int group;

        public Manage(String studentCode, String studentName, String phoneNumber, int group) {
            this.studentCode = studentCode;
            this.studentName = studentName;
            this.phoneNumber = phoneNumber;
            this.group = group;
        }
        public String getStudentCode() {
            return studentCode;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),
                m = scanner.nextInt();
        ArrayList<Manage> manages = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String studentCode = scanner.nextLine(),
                    studentName = scanner.nextLine(),
                    phoneNumber = scanner.nextLine();
            int group = scanner.nextInt();
            manages.add(new Manage(studentCode, studentName, phoneNumber, group));
        }
        Map<Integer, String> map = new HashMap<>();
        scanner.nextLine();
        for (int i = 1; i <= m; ++i) {
            String assign = scanner.nextLine();
            map.put(i, assign);
        }
        manages.sort(
                Comparator.comparing(Manage::getStudentCode)
        );
        for (int i = 0; i < manages.size(); ++i) {
            Manage manage = manages.get(i);
            System.out.println(manage.studentCode + " " + manage.studentName + " " + manage.phoneNumber + " " +
                    manage.group + " " + map.get(manage.group));
        }
        scanner.close();
    }
}
