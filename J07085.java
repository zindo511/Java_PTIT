import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class J07085 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> list = (ArrayList<String>) ois.readObject();
        ois.close();

        for (String s : list) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) >= '0' && s.charAt(j) <= '9')
                    sb.append(s.charAt(j));
            }
            while (sb.charAt(0) == '0')
                sb.deleteCharAt(0);
            System.out.println(sb.toString() + ' ' + total(sb.toString()));
        }
    }

    static int total(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); ++i)
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        return sum;
    }
}
