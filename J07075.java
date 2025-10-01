import java.io.File;
import java.util.*;

public class J07075 {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(scanner1.nextLine());
        Map<String, String> map1 = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            String codeSubject = scanner1.nextLine(),
                    nameSubject = scanner1.nextLine(),
                    numCredit = scanner1.nextLine();
            map1.put(codeSubject.trim(), nameSubject);
        }

        Scanner scanner2 = new Scanner(new File("LICHGD.in"));
        int m = Integer.parseInt(scanner2.nextLine());
        Map<String, ArrayList<Teacher>> map2 = new HashMap<>();
        for (int i = 1; i <= m; ++i) {
            String codeGroup = "HP" + String.format("%03d", i),
                    codeSubject = scanner2.nextLine(),
                    day = scanner2.nextLine(),
                    kip = scanner2.nextLine(),
                    nameTeacher = scanner2.nextLine(),
                    classRoom = scanner2.nextLine();
            map2.computeIfAbsent(nameTeacher, k -> new ArrayList<>()).add(new Teacher(codeGroup, codeSubject, day, kip, classRoom));
        }
        String nameTeacher = scanner2.nextLine();
        System.out.println("LICH GIANG DAY GIANG VIEN " + nameTeacher + ":");
        ArrayList<Teacher> teachers = map2.get(nameTeacher);
        teachers.sort(
                Comparator.comparing(Teacher::getDay)
                        .thenComparing(Teacher::getKip)
        );
        for (Teacher teacher : teachers) {
            System.out.println(teacher.codeGroup + " " + map1.get(teacher.codeSubject) + " " + teacher.day + " " + teacher.kip + " " + teacher.classRoom);
        }
        scanner1.close();
        scanner2.close();
    }

    static class Teacher {
        String codeGroup, codeSubject, day, kip, classRoom;

        public Teacher(String codeGroup, String codeSubject, String day, String kip, String classRoom) {
            this.codeGroup = codeGroup;
            this.codeSubject = codeSubject;
            this.day = day;
            this.kip = kip;
            this.classRoom = classRoom;
        }

        public String getDay() {
            return day;
        }

        public String getKip() {
            return kip;
        }
    }
}
