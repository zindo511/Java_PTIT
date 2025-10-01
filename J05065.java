import java.util.*;

public class J05065 {
    static class Staff {
        private final String staffCode;
        private final String fullName;
        public Staff(String staffCode, String fullName) {
            this.staffCode = staffCode;
            this.fullName = fullName;
        }
        public String getRankSalary() {
            return staffCode.substring(2, 4);
        }
        public String getCode() {
            return staffCode.substring(4);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Staff> staffs = new ArrayList<>();
        int cntGd = 0, cntTp = 0, cntPp = 0;
        for (int i = 1; i <= n; ++i) {
            String staffCode = scanner.next(), fullName = scanner.nextLine();
            if (staffCode.startsWith("GD")) cntGd++;
            else if (staffCode.startsWith("TP")) cntTp++;
            else if (staffCode.startsWith("PP")) cntPp++;
            if (cntGd >= 2 || cntTp >= 4 || cntPp >= 4) staffCode = "NV" + staffCode.substring(2);
            staffs.add(new Staff(staffCode, fullName));
        }
        staffs.sort(
                Comparator.comparing(Staff::getRankSalary, Comparator.reverseOrder())
                        .thenComparing(Staff::getCode)
        );
        ArrayList<Staff> gd = new ArrayList<>(), tp = new ArrayList<>(), pp = new ArrayList<>(), nv = new ArrayList<>();
        for (Staff staff : staffs) {
            String position = staff.staffCode.substring(0, 2);
            if (position.equals("GD")) gd.add(staff);
            else if (position.equals("TP")) tp.add(staff);
            else if (position.equals("PP")) pp.add(staff);
            else nv.add(staff);
        }
        Map<String, ArrayList<Staff>> map = new HashMap<>();
        map.put("GD", gd);
        map.put("TP", tp);
        map.put("PP", pp);
        map.put("NV", nv);
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; ++i) {
            String s = scanner.nextLine();
            ArrayList<Staff> a = map.get(s);
            for (Staff staff : a) {
                System.out.println(staff.fullName.trim() + " " + staff.staffCode.substring(0, 2) + " " + staff.getCode() + " " + staff.getRankSalary());
            }
            System.out.println();
        }
        scanner.close();
    }
}
