import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05026 {
    static String trans (String s) {
        s = s.toUpperCase();
        String[] parts = s.split("\\s+");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parts.length; ++i){
            result.append(parts[i].charAt(0));
        }
        return result.toString();
    }

    static String lastName (String s) {
        String[] parts = s.split("\\s+");
        return parts[parts.length - 1];
    }
    static class Teacher {
        private String name, subject, code;

        public Teacher(String code, String name, String subject) {
            this.code = code;
            this.name = name;
            this.subject = subject;
        }

        @Override
        public String toString(){
            return "GV" + code +  " " + name + " " + subject;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Teacher> teachers = new ArrayList<>();
        for (int i = 1; i <= t; ++i){
            String name = scanner.nextLine(),
                    subject = scanner.nextLine();

            String code = String.valueOf(i);
            if (code.length() == 1) code = "0" + code;
            teachers.add(new Teacher(code, name, trans(subject)));
        }

        int q = scanner.nextInt();
        scanner.nextLine();
        while (q-- > 0) {
            String s = scanner.nextLine();
            s = trans(s);
            System.out.println("DANH SACH GIANG VIEN BO MON " + s + ":");
            for (int i = 0; i < teachers.size(); ++i) {
                Teacher gv = teachers.get(i);
                if (gv.subject.equals(s)) System.out.println("GV" + gv.code + " " + gv.name + " " + gv.subject);
            }
        }
        scanner.close();
    }
}
