import java.io.File;
import java.io.IOException;
import java.util.*;

public class J07009 {
    static class IntSet {
        int[] a;
        public IntSet(int[] a){
            this.a = a;
        }

        public IntSet intersection(IntSet other) {
            Set<Integer> set = new TreeSet<>();
            Set<Integer> set2 = new TreeSet<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i : a)
                map.put(i, 1);

            for (int i : other.a)
                set2.add(i);
            for (int j : set2){
                if (map.containsKey(j)) set.add(j);
            }

            int[] res = new int[set.size()];
            int i = 0;
            for (int j : set)
                res[i++] = j;

            return new IntSet(res);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i : a)
                sb.append(i).append(" ");
            return sb.toString().trim();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}
