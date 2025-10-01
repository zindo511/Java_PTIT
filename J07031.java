import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class J07031 {
    static int MAX = 1000000;
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();
        ois.close();

        ObjectInputStream ois2= new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();

        Set<Integer> set1 = new HashSet<>(list);
        Set<Integer> set2 = new HashSet<>(list2);
        boolean[] primes = sieve();

        Set<Pair> pairs = new TreeSet<>(Comparator.comparingInt(Pair::getN));
        for (int n : set1) {
            int m = 1000000 - n;
            if (n > 0 && set1.contains(m) && n < m && primes[n] && primes[m] && !set2.contains(n) && !set2.contains(m)) {
                pairs.add(new Pair(n, m));
            }
        }
        for (Pair pair : pairs)
            System.out.println(pair.n + " " + pair.m);

    }
    static boolean[] sieve() {
        boolean[] primes = new boolean[MAX + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= MAX; ++i) {
            if (primes[i])
                for (int j = i * i; j<= MAX; j += i)
                    primes[j] = false;
        }
        return primes;
    }

    static class Pair {
        int n, m;
        public Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
        public int getN() {
            return n;
        }
    }
}
