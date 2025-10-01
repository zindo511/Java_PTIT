import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05007 {
    static class Employee {
        private String ma, ten, gt, ns, dc, mst, nkhd;

        public Employee(String ma, String ten, String gt, String ns, String dc, String mst, String nkhd) {
            this.ma = ma;
            this.ten = ten;
            this.gt = gt;
            this.ns = ns;
            this.dc = dc;
            this.mst = mst;
            this.nkhd = nkhd;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + gt + " " + ns + " " + dc + " " + mst + " " + nkhd;
        }
    }

    static int year(String s) {
        String[] parts = s.split("/");
        return Integer.valueOf(parts[2]);
    }

    static int month(String s) {
        String[] parts = s.split("/");
        return Integer.valueOf(parts[1]);
    }

    static int day(String s) {
        String[] parts = s.split("/");
        return Integer.valueOf(parts[0]);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            String ma = String.format("%05d", i);
            String ten = scanner.nextLine(),
                    gt = scanner.nextLine(),
                    ns = scanner.nextLine(),
                    dc = scanner.nextLine(),
                    mst = scanner.nextLine(),
                    nkhd = scanner.nextLine();
            employees.add(new Employee(ma, ten, gt, ns, dc, mst, nkhd));
        }

        employees.sort(
                Comparator.comparing((Employee employee) -> year(employee.ns))
                        .thenComparing((Employee employee) -> month(employee.ns))
                        .thenComparing((Employee employee) -> day(employee.ns))
        );

        employees.forEach(System.out::println);
        scanner.close();
    }
}
