import java.io.File;
import java.util.*;

public class J07038 {
    static class Company {
        String nameCompany;
        int num;
        public Company(String n, int u) {
            this.nameCompany = n;
            this.num = u;
        }
    }

    static class  Student {
        String codeStudent, fullName, lop;
        public Student(String codeStudent, String fullName, String lop) {
            this.codeStudent = codeStudent;
            this.fullName = fullName;
            this.lop = lop;
        }
    }

    public static void main(String[] args) throws Exception {
        Map<String, Company> map1 = new HashMap<>();
        Map<String, ArrayList<String>> map2 = new HashMap<>();
        Map<String, Student> map3 = new TreeMap<>();

        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc1.nextLine());
        for (int i = 1; i <= n; ++i) {
            String codeStudent = sc1.nextLine(),
                    fullName = tranName(sc1.nextLine()),
                    lop = sc1.nextLine(),
                    email = sc1.nextLine().trim();
            map3.put(codeStudent, new Student(codeStudent, fullName, lop));
        }
        sc1.close();

        Scanner sc2 = new Scanner(new File("DN.in"));
        n = Integer.parseInt(sc2.nextLine());
        for (int i = 1; i <= n; ++i) {
            String codeCompany = sc2.nextLine(),
                    nameCompany = sc2.nextLine();
            int num = Integer.parseInt(sc2.nextLine().trim());
            map1.put(codeCompany, new Company(nameCompany, num));
        }
        sc2.close();

        Scanner sc3 = new Scanner(new File("THUCTAP.in"));
        n = Integer.parseInt(sc3.nextLine());
        for (int i = 1; i <= n; ++i) {
            String codeStudent = sc3.next(), codeCompany = sc3.next();
            map2.putIfAbsent(codeCompany, new ArrayList<>());
            map2.get(codeCompany).add(codeStudent);
        }
        int m = sc3.nextInt();
        for (int i = 1; i <= m; ++i) {
            String codeCompany = sc3.next();
            System.out.println("DANH SACH THUC TAP TAI " + map1.get(codeCompany).nameCompany + ":");
            ArrayList<String> stu = map2.get(codeCompany);
            if (stu == null) continue;
            stu.sort(Comparator.naturalOrder());
            int num = map1.get(codeCompany).num;
            for (int j = 0; j < stu.size(); ++j) {
                Student student = map3.get(stu.get(j));
                if (j < num) System.out.println(student.codeStudent + " " + student.fullName + " " + student.lop);
            }
        }
        sc3.close();
    }
    static String tranName(String s) {
        String[] parts = s.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(part.substring(0, 1).toUpperCase()).append(part.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
}
