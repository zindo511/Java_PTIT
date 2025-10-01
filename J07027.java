import java.io.File;
import java.util.*;

public class J07027 {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(new File("SINHVIEN.in"));

        Map<String, Student> map1 = new HashMap<>();
        int n = Integer.parseInt(scanner1.nextLine());
        for (int i = 1; i <= n; ++i) {
            String codeStudent = scanner1.nextLine(),
                    fullName = scanner1.nextLine(),
                    numberPhone = scanner1.nextLine();
            map1.put(codeStudent, new Student(fullName, numberPhone));
        }

        Scanner scanner2 = new Scanner(new File("BAITAP.in"));
        Map<Integer, String> map2 = new HashMap<>();
        int m = Integer.parseInt(scanner2.nextLine());
        for (int i = 1; i <= m; ++i) {
            String exercise = scanner2.nextLine();
            map2.put(i, exercise);
        }

        Scanner scanner3 = new Scanner(new File("NHOM.in"));
        ArrayList<Group> groups = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            String codeStudent = scanner3.next();
            int stt = scanner3.nextInt();
            groups.add(new Group(codeStudent, stt));
            scanner3.nextLine();
        }

        groups.sort(
                Comparator.comparing(Group::getCodeStudent)
        );

        for (Group group : groups) {
            String codeStudent = group.codeStudent;
            int stt = group.stt;
            Student student = map1.get(codeStudent);

            System.out.println(codeStudent + " " + student.fullName + " " + student.numberPhone + " " +
                    stt + " " + map2.get(stt));
        }
        scanner1.close();
        scanner2.close();
        scanner3.close();
    }

    static class Student {
        String fullName, numberPhone;

        public Student(String fullName, String numberPhone) {
            this.fullName = fullName;
            this.numberPhone = numberPhone;
        }
    }

    static class Group {
        String codeStudent;
        int stt;

        public Group(String codeStudent, int stt) {
            this.codeStudent = codeStudent;
            this.stt = stt;
        }

        public String getCodeStudent() {
            return codeStudent;
        }
    }
}
