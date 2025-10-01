import java.util.*;

public class J04022 {
    static class WordSet {
        String s;

        public WordSet(String s) {
            this.s = s;
        }
        public WordSet union(WordSet other) {
            String[] parts1 = s.toLowerCase().trim().split("\\s+");
            String[] parts2 = other.toString().toLowerCase().trim().split("\\s+");

            Set<String> set = new TreeSet<>();
            Collections.addAll(set, parts1);
            Collections.addAll(set, parts2);

            StringBuilder res = new StringBuilder();
            for (String i : set)
                res.append(i).append(" ");

            return new WordSet(res.toString().trim());
        }

        public WordSet intersection(WordSet other) {
            Map<String, Integer> map = new HashMap<>();
            Map<String, Integer> map2 = new TreeMap<>();
            String[] parts1 = s.toLowerCase().trim().split("\\s+");
            String[] parts2 = other.toString().toLowerCase().trim().split("\\s+");

            for (String i : parts1)
                map.put(i, 1);

            for (String i : parts2) {
                if (map.containsKey(i)) map2.put(i, 1);
            }
            StringBuilder res = new StringBuilder();
            for (Map.Entry<String, Integer> entry : map2.entrySet()) {
                res.append(entry.getKey()).append(" ");
            }

            return new WordSet(res.toString().trim());
        }

        public String toString() {
            return s;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
