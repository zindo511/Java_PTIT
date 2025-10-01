import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J06003 {
    static class Manage {
        private String studentCode, studentName, phoneNumber;
        private int group;

        public Manage(String studentCode, String studentName, String phoneNumber, int group) {
            this.studentCode = studentCode;
            this.studentName = studentName;
            this.phoneNumber = phoneNumber;
            this.group = group;
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
        int q = scanner.nextInt();
        while (q-- > 0) {
            int x = scanner.nextInt();
            System.out.println("DANH SACH NHOM " + x + ":");
            for (int i = 0; i < manages.size(); ++i) {
                Manage manage = manages.get(i);
                if (manage.group == x) {
                    System.out.println(manage.studentCode + " " + manage.studentName + " " + manage.phoneNumber);
                }
            }
            System.out.println("Bai tap dang ky: " + map.get(x));
        }
        scanner.close();
    }
}
