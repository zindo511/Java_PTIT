import java.io.File;
import java.text.DecimalFormat;
import java.util.*;

public class J07036 {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(scanner1.nextLine());
        Map<String, ArrayList<Student>> map1 = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            String codeStudent = scanner1.nextLine(),
                    fullName = transName(scanner1.nextLine()),
                    lop = scanner1.nextLine(),
                    email = scanner1.nextLine();
            map1.computeIfAbsent(lop, k -> new ArrayList<>()).add(new Student(codeStudent, fullName));
        }

        Scanner scanner2 = new Scanner(new File("MONHOC.in"));
        int m = Integer.parseInt(scanner2.nextLine());
        Map<String, String> map2 = new HashMap<>();
        for (int i = 1; i <= m; ++i) {
            String codeSubject = scanner2.nextLine(),
                    nameSubject = scanner2.nextLine();
            int numCredit = Integer.parseInt(scanner2.nextLine());
            map2.put(codeSubject, nameSubject);
        }

        Scanner scanner3 = new Scanner(new File("BANGDIEM.in"));
        int k = Integer.parseInt(scanner3.nextLine());
        Map<String, ArrayList<Subject>> map3 = new HashMap<>();
        for (int i = 1; i <= k; ++i) {
            String[] parts = scanner3.nextLine().trim().split("\\s+");
            String codeStudent = parts[0];
            String codeSubject = parts[1];
            double score = Double.parseDouble(parts[2]);
            map3.computeIfAbsent(codeStudent, key -> new ArrayList<>()).add(new Subject(codeSubject, score));
        }

        int x = Integer.parseInt(scanner3.nextLine());
        for (int i = 1; i <= x; ++i) {
            ArrayList<Compile> compiles = new ArrayList<>();
            String lop = scanner3.nextLine();

            ArrayList<Student> students = map1.get(lop);
            for (Student student : students) {
                String codeStudent = student.codeStudent,
                        fullName = student.fullName;
                ArrayList<Subject> subjects = map3.get(codeStudent);
                if (subjects == null) continue;
                for (Subject subject : subjects) {
                    String codeSubject = subject.codeSubject;
                    String nameSubject = map2.get(codeSubject);
                    compiles.add(new Compile(codeStudent, fullName, codeSubject, nameSubject, subject.score));
                }
            }
            compiles.sort(
                    Comparator.comparing(Compile::getCodeSubject)
                            .thenComparing(Compile::getCodeStudent)
            );

            System.out.println("BANG DIEM lop " + lop + ":");
//            DecimalFormat df = new DecimalFormat("#.##");
            for (Compile compile : compiles)
                System.out.println(compile.codeStudent + " " + compile.fullName + " " +
                        compile.codeSubject + " " + compile.nameSubject + " " + roundScore(compile.score));
        }
        scanner1.close();
        scanner2.close();
        scanner3.close();
    }

    static class Student {
        String codeStudent, fullName;

        public Student(String codeStudent, String fullName) {
            this.codeStudent = codeStudent;
            this.fullName = fullName;
        }
    }

    static class Subject {
        String codeSubject;
        double score;

        public Subject(String codeSubject, double score) {
            this.codeSubject = codeSubject;
            this.score = score;
        }
    }

    static class Compile {
        String codeStudent, fullName, codeSubject, nameSubject;
        double score;

        public Compile(String codeStudent, String fullName, String codeSubject, String nameSubject, double score) {
            this.codeStudent = codeStudent;
            this.fullName = fullName;
            this.codeSubject = codeSubject;
            this.nameSubject = nameSubject;
            this.score = score;
        }

        public String getCodeSubject() {
            return codeSubject;
        }

        public String getCodeStudent() {
            return codeStudent;
        }
    }

    static String transName(String fullName) {
        String[] parts = fullName.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts)
            sb.append(part.substring(0, 1).toUpperCase()).append(part.substring(1)).append(" ");
        return sb.toString().trim();
    }

    static String roundScore(double score) {
        if (score == (int) score) return String.valueOf((int) score);
        return String.valueOf(score);
    }
}

//lớp: mã học sinh, tên học sinh map1
//
//từ mã học sinh phải lấy ra được: mã môn học, điểm map3
//từ mã môn học lấy ra được tên môn