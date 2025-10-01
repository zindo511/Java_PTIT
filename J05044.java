import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class J05044 {
    static class Employee {
        private String ma, ten, chucVu;
        private int phuCap, luongChinh, tamUng, conLai;

        public Employee (String ma, String ten, int phuCap, int luongChinh, int tamUng, int conLai, String chucVu) {
            this.ma = ma;
            this.ten = ten;
            this.phuCap = phuCap;
            this.luongChinh = luongChinh;
            this.tamUng = tamUng;
            this.conLai = conLai;
            this.chucVu = chucVu;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String ma = "NV" + String.format("%02d", i);
            String ten = scanner.nextLine(),
                    chucVu = scanner.nextLine();
            int luong = scanner.nextInt(),
                    ngayCong = scanner.nextInt();
            int phuCap, luongChinh = luong * ngayCong, tamUng, conLai;
            if (chucVu.equals("GD")) phuCap = 500;
            else if (chucVu.equals("PGD")) phuCap = 400;
            else if (chucVu.equals("TP")) phuCap = 300;
            else if (chucVu.equals("KT")) phuCap = 250;
            else phuCap = 100;

            double val = (phuCap + luongChinh) * 2.0 / 3;
            if (val < 25000){
                tamUng = (int) Math.round(val / 1000) * 1000;
            }
            else tamUng = 25000;
            conLai = luongChinh + phuCap - tamUng;

            employees.add(new Employee(ma, ten, phuCap, luongChinh, tamUng, conLai, chucVu));
        }

        scanner.nextLine();
        String s = scanner.nextLine();
        for (int i = 0; i < employees.size(); ++i) {
            Employee employee = employees.get(i);
            if (employee.chucVu.equals(s))
                System.out.println(employee.ma + " " + employee.ten + " " + employee.phuCap + " " + employee.luongChinh + " "
                        + employee.tamUng + " " + employee.conLai);
        }
        scanner.close();
    }
}
