import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J05078 {
    static class Salary {
        private String code, name, ma;
        private long salary;

        public Salary(String code, String name, long salary, String ma) {
            this.code = code;
            this.name = name;
            this.salary = salary;
            this.ma = ma;
        }
    }
    static long heSo(String s) {
        String group = s.substring(0, 1);
        int year = Integer.parseInt(s.substring(1, 3));
        if (year >= 1 && year <= 3){
            if (group.equals("A") || group.equals("B"))
                return 10;
            if (group.equals("C")) return 9;
            if (group.equals("D")) return 8;
        }
        if (year >= 4 && year <= 8){
            if (group.equals("A")) return 12;
            if (group.equals("B")) return 11;
            if (group.equals("C")) return 10;
            if (group.equals("D")) return 9;
        }
        if (year >= 9 && year <= 15){
            if (group.equals("A")) return 14;
            if (group.equals("B")) return 13;
            if (group.equals("C")) return 12;
            if (group.equals("D")) return 11;
        }
        if (group.equals("A")) return 20;
        if (group.equals("B")) return 16;
        if (group.equals("C")) return 14;
        return 13;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            String roomCode = scanner.next(),
                    roomName = scanner.nextLine();
            map.put(roomCode, roomName);
        }
        int q = scanner.nextInt();
        ArrayList<Salary> salaries = new ArrayList<>();
        for (int i = 1; i <= q; ++i) {
            scanner.nextLine();
            String code = scanner.nextLine(),
                    name = scanner.nextLine();
            long lcb = scanner.nextInt(),
                    snc = scanner.nextInt();
            String phong = code.substring(code.length() - 2);
            salaries.add(new Salary(code, name, lcb * snc * heSo(code) * 1000, phong));
        }
        scanner.nextLine();
        String ma = scanner.nextLine();
        System.out.println("Bang luong phong" + map.get(ma) + ":");
        for (int i = 0; i < salaries.size(); ++i) {
            Salary salary = salaries.get(i);
            String phong = salary.ma;
            if (phong.equals(ma)){
                System.out.println(salary.code + " " + salary.name + " " + salary.salary);
            }
        }
        scanner.close();
    }
}
