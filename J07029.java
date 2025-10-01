import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class J07029 {
    static boolean check(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();
        ois.close();
        Map<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> a = new ArrayList<>();
        for (int x : list) {
            if (check(x)) {
                if (!freq.containsKey(x)) a.add(x);
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }
        }
        a.sort(
                Comparator.reverseOrder()
        );
        for (int i = 0; i < 10; ++i) {
            int x = a.get(i);
            System.out.println(x + " " + freq.get(x));
        }
    }
}
