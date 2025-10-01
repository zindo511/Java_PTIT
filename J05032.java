import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05032 {
    static class Age {
        private String ten, ns;

        public Age(String ten, String ns) {
            this.ten = ten;
            this.ns = ns;
        }
    }
    static int year(String s) {
        String[] parts = s.split("/");
        return Integer.valueOf(parts[2]);
    }

    static int month(String s) {
        String[] parts = s.split("/");
        return Integer.valueOf(parts[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Age> ages = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            String ten = scanner.next(),
                    ns = scanner.next();
            ages.add(new Age(ten, ns));
        }

        ages.sort(
                Comparator.comparing((Age age) -> year(age.ns))
                        .thenComparing((Age age) -> month(age.ns))
        );

        System.out.println(ages.get(t - 1).ten);
        System.out.println(ages.get(0).ten);
        scanner.close();
    }
}
