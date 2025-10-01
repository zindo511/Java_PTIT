import java.util.ArrayList;
import java.util.Scanner;

public class J05027 {
    static class Teacher {
        private String ma, ten, mon;

        public Teacher(String ma, String ten, String mon) {
            this.ma = ma;
            this.ten = ten;
            this.mon = mon;
        }

    }

    static String trans(String s) {
        String[] parts = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parts.length; ++i){
            parts[i] = parts[i].toUpperCase();
            res.append(parts[i].charAt(0));
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Teacher> teachers = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            String ma = String.valueOf(i);
            while (ma.length() < 2) ma = "0" + ma;
            String ten = scanner.nextLine(),
                    mon = scanner.nextLine();
            teachers.add(new Teacher(ma, ten, mon));
        }
        int q = scanner.nextInt();
        scanner.nextLine();
        while (q-- > 0) {
            String s = scanner.nextLine();
            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + s + ":");
            s = s.toLowerCase();
            for (int i = 0; i < teachers.size(); ++i) {
                Teacher gv = teachers.get(i);
                String name = gv.ten.toLowerCase();
                int pos = name.indexOf(s);
                if (pos != -1) {
                    System.out.println("GV" + gv.ma + " " + gv.ten + " " + trans(gv.mon));
                }
            }
        }
        scanner.close();
    }
}
