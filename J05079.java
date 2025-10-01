import java.util.*;

public class J05079 {
    static class Group {
        private String subjectCode, subjectName, group, teacher;
        public Group(String subjectCode, String subjectName, String group, String teacher) {
            this.subjectCode = subjectCode;
            this.subjectName = subjectName;
            this.group = group;
            this.teacher = teacher;
        }
    }
    static class Sx {
        private String code, name;
        public Sx(String code, String name) {
            this.code = code;
            this.name = name;
        }
        public String getCode() {
            return code;
        }
        @Override
        public String toString() {
            return code + " " + name;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Group> groups = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            String subjectCode = scanner.nextLine(),
                    subjectName = scanner.nextLine(),
                    group = scanner.nextLine(),
                    teacher = scanner.nextLine();
            map.put(subjectCode, subjectName);
            groups.add(new Group(subjectCode, subjectName, group, teacher));
        }
        int q = Integer.parseInt(scanner.nextLine());
        while (q-- > 0) {
            String subjectCode = scanner.nextLine();
            System.out.println("Danh sach nhom lop mon " + map.get(subjectCode) + ":");
            ArrayList<Sx> sxes = new ArrayList<>();
            for (int i = 0; i < groups.size(); ++i) {
                Group group = groups.get(i);
                if (group.subjectCode.equals(subjectCode))
                    sxes.add(new Sx(group.group, group.teacher));
            }
            sxes.sort(
                    Comparator.comparing(Sx::getCode)
            );
            sxes.forEach(System.out::println);

        }
        scanner.close();
    }
}
