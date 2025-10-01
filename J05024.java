import java.util.ArrayList;
import java.util.Scanner;

public class J05024 {
    static class Student {
        String codeStudent, fullName, lop, email;

        public Student(String codeStudent, String fullName, String lop, String email) {
            this.codeStudent = codeStudent;
            this.fullName = fullName;
            this.lop = lop;
            this.email = email;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            String codeStudent = scanner.nextLine(), fullName = scanner.nextLine(), lop = scanner.nextLine(), email = scanner.nextLine();
            students.add(new Student(codeStudent, fullName, lop, email));
        }

        int q = Integer.parseInt(scanner.nextLine());
        while (q-- > 0) {
            String s = scanner.nextLine();
            System.out.println("DANH SACH SINH VIEN NGANH " + trans(s) + ":");
            for (Student student : students) {
                if (check(student.codeStudent, student.lop).equals(firstsWord(s)))
                    System.out.println(student.codeStudent + " " + student.fullName + " " + student.lop + " " + student.email);
            }
        }
        scanner.close();
    }

    static String trans(String s) {
        return s.toUpperCase();
    }

    static String check(String s, String c) {
        String ans = s.substring(3, 7);
        if (ans.equals("DCKT")) return "KT";
        if (ans.equals("DCCN") && c.charAt(0) != 'E') return "CNTT";
        if (ans.equals("DCAT") && c.charAt(0) != 'E') return "ATTT";
        if (ans.equals("DCVT")) return "VT";
        if (ans.equals("DCDT")) return "DT";
        return "";
    }

    static String firstsWord(String s){
        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String part : parts)
            sb.append(part.toUpperCase().charAt(0));
        return sb.toString();
    }
}