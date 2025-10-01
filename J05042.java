import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05042 {
    static class Rank {
        private String ten;
        private int c, t;

        public Rank(String ten, int c, int t) {
            this.ten = ten;
            this.c = c;
            this.t = t;
        }

        @Override
        public String toString() {
            return ten + " " + c + " " + t;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Rank> ranks = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String ten = scanner.nextLine();
            int c = scanner.nextInt(),
                    t = scanner.nextInt();
            ranks.add(new Rank(ten, c, t));
        }
        ranks.sort(
                Comparator.comparing((Rank rank) -> rank.c, Comparator.reverseOrder())
                        .thenComparing((Rank rank) -> rank.t)
                        .thenComparing((Rank rank) -> rank.ten)
        );
        ranks.forEach(System.out::println);
        scanner.close();
    }
}
