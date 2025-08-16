import java.util.Scanner;

public class J01010 {
    static String huy(String s){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '0' || c == '8' || c == '9') result.append('0');
            else if (c == '1') result.append('1');
            else return "INVALID";
        }
        return result.toString();
    }
    static String delete(String s){
        String result = s.replaceFirst("^0+", "");
        if (result.equals("")) return "INVALID";
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String s = scanner.nextLine();
            String cut = huy(s);
            if (cut.equals("INVALID"))
                System.out.println("INVALID");
            else
                System.out.println(delete(cut));
        }
        scanner.close();
    }
}
