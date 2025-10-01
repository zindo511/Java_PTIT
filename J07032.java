import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class J07032 {
    static boolean check(int x) {
        String s = String.valueOf(x);
        int l = 0, r = s.length() - 1;
        if (r <= 1 || r % 2 == 0) return false;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            if ((s.charAt(l) - '0') % 2 == 0 || (s.charAt(r) - '0') % 2 == 0) return false;
            ++l; --r;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> list1 = (ArrayList<Integer>) ois.readObject();
        ois.close();

        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois1.readObject();
        ois1.close();

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set2 = new HashSet<>(list2);
        Set<Integer> set1 = new HashSet<>(list1);

        for (int n : list1) {
            if (check(n)) map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : list2) {
            if (check(n)) map.put(n, map.getOrDefault(n, 0) + 1);
        }

        set1.retainAll(set2);
        TreeSet<Integer>set = new TreeSet<>(set1);

        int cnt = 0;
        for (int n : set){
            if (check(n)) {
                ++cnt;
                if (cnt > 10) {
                    return;
                }
                System.out.println(n + " " + map.get(n));
            }
        }
    }
}
