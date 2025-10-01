import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J04021 {
    static class IntSet{
        int[] a;
        public IntSet(int[] a) {
            this.a = a;
        }

        public IntSet union(IntSet other) {
            Set<Integer> set = new TreeSet<>();
            for (int x : this.a) {
                set.add(x);
            }
            for (int x : other.a) {
                set.add(x);
            }

            int[] c = new int[set.size()];
            int i = 0;
            for (int x : set)
                c[i++] = x;
            return new IntSet(c);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int x : a) sb.append(x).append(" ");
            return sb.toString().trim();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
}
