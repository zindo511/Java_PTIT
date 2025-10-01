import java.util.*;

public class J05080 {
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
        private String subjectCode, subjectName, group;
        public Sx(String subjectCode, String subjectName, String group) {
            this.subjectCode = subjectCode;
            this.subjectName = subjectName;
            this.group = group;
        }
        public String getSubjectCode() {
            return subjectCode;
        }
        public String getGroup() {
            return group;
        }
        @Override
        public String toString() {
            return subjectCode + " " + subjectName + " " + group;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Group> groups = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            String subjectCode = scanner.nextLine(),
                    subjectName = scanner.nextLine(),
                    group = scanner.nextLine(),
                    teacher = scanner.nextLine();
            groups.add(new Group(subjectCode, subjectName, group, teacher));
        }
        int q = Integer.parseInt(scanner.nextLine());
        while (q-- > 0) {
            String teacher = scanner.nextLine();
            System.out.println("Danh sach cho giang vien " + teacher + ":");
            ArrayList<Sx> sxes = new ArrayList<>();
            for (int i = 0; i < groups.size(); ++i) {
                Group group = groups.get(i);
                if (group.teacher.equals(teacher))
                    sxes.add(new Sx(group.subjectCode, group.subjectName, group.group));
            }
            sxes.sort(
                    Comparator.comparing(Sx::getSubjectCode)
                            .thenComparing(Sx::getGroup)
            );
            sxes.forEach(System.out::println);

        }
        scanner.close();
    }
}
