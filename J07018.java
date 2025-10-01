import java.io.File;
import java.util.Scanner;

public class J07018 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; ++i) {
            String codeStudent = "B20DCCN" + String.format("%03d", i);
            String fullName = transName(scanner.nextLine()),
                    lop = scanner.nextLine(),
                    birth = transBirth(scanner.nextLine());
            double gpa = Double.parseDouble(scanner.nextLine());
            System.out.println(codeStudent + " " + fullName + " " + lop + " " + birth + " " + String.format("%.02f", gpa));
        }
        scanner.close();
    }

    static String transName(String s){
        s = s.trim().toLowerCase();
        String[] parts = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(part.substring(0, 1).toUpperCase()).append(part.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    static String transBirth(String s) {
        String[] parts = s.split("/");
        if (parts[0].length() == 1) parts[0] = "0" + parts[0];
        if (parts[1].length() == 1) parts[1] = "0" + parts[1];
        return parts[0] + "/" + parts[1] + "/" + parts[2];
    }
}
