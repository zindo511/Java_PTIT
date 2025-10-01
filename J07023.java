import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;


public class J07023 {
    static int MAX = 1000000;
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ois1.close();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();

        boolean[] primes = sieve();

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int n : list1)
            map1.put(n, map1.getOrDefault(n, 0) + 1);

        for (int n : list2)
            map2.put(n, map2.getOrDefault(n, 0) + 1);

        Set<Integer> set = new TreeSet<>();
        Set<Integer> set1 = new TreeSet<>(list1);
        Set<Integer> set2 = new TreeSet<>(list2);
        set1.retainAll(set2);

        for (int n : set1) {
            if (primes[n] && isPando(n))
                set.add(n);
        }

        for (int n : set)
            System.out.println(n + " " + map1.get(n) + " " + map2.get(n));
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
    static boolean isPando(int n) {
        String s = String.valueOf(n);
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            ++l; --r;
        }
        return true;
    }
}
