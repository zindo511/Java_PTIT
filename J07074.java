import java.io.File;
import java.util.*;

public class J07074 {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(scanner1.nextLine());
        Map<String, String> map1 = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            String codeSubject = scanner1.nextLine(),
                    nameSubject = scanner1.nextLine(),
                    numCredit = scanner1.nextLine();
            map1.put(codeSubject, nameSubject);
        }

        Scanner scanner2 = new Scanner(new File("LICHGD.in"));
        int m = Integer.parseInt(scanner2.nextLine());
        Map<String, ArrayList<Subject>> map2 = new HashMap<>();
        for (int i = 1; i <= m; ++i) {
            String  codeGroup = "HP" + String.format("%03d", i),
                    codeSubject = scanner2.nextLine(),
                    day = scanner2.nextLine(),
                    kip = scanner2.nextLine(),
                    nameTeacher = scanner2.nextLine(),
                    classRoom = scanner2.nextLine();
            map2.computeIfAbsent(codeSubject, k -> new ArrayList<>()).add(new Subject(codeGroup, day, kip, nameTeacher, classRoom));
        }

        String codeSubject = scanner2.nextLine();
        System.out.println("LICH GIANG DAY MON " + map1.get(codeSubject) + ":");
        ArrayList<Subject> subjects = map2.get(codeSubject);
        subjects.sort(
                Comparator.comparing(Subject::getDay)
                        .thenComparing(Subject::getKip)
                        .thenComparing(Subject::getNameTeacher)
        );
        subjects.forEach(System.out::println);

        scanner1.close();
        scanner2.close();
    }

    static class Subject {
        String codeGroup, day, kip, nameTeacher, classRoom;

        public Subject(String codeGroup, String day, String kip, String nameTeacher, String classRoom) {
            this.codeGroup = codeGroup;
            this.day = day;
            this.kip = kip;
            this.nameTeacher = nameTeacher;
            this.classRoom = classRoom;
        }

        public String getDay() {
            return day;
        }

        public String getKip() {
            return kip;
        }
        public String getNameTeacher() {
            return nameTeacher;
        }

        public String toString() {
            return codeGroup + " " + day + " " + kip + " " + nameTeacher + " " + classRoom;
        }
    }
}
