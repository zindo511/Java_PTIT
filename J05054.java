import java.util.*;

public class J05054 {
    static class Rank {
        private String ten, xepLoai, ma;
        private double dtb;

        public Rank(String ma, String ten, double dtb, String xepLoai) {
            this.ma = ma;
            this.ten = ten;
            this.dtb = dtb;
            this.xepLoai = xepLoai;
        }
    }

    static String trans(double x) {
        if (x >= 9) return "Gioi";
        if (x >= 7) return "Kha";
        if (x >= 5) return "Trung Binh";
        return "Yeu";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        ArrayList<Rank> ranks = new ArrayList<>();
        Map<Double, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int i = 1; i <= t; ++i) {
            scanner.nextLine();
            String ma = "HS" + String.format("%02d", i);
            String ten = scanner.nextLine();
            double dtb = scanner.nextDouble();

            String xepLoai = trans(dtb);
            ranks.add(new Rank(ma, ten, dtb, xepLoai));
        }

        ArrayList<Rank> copied = new ArrayList<>(ranks);
        copied.sort(
                Comparator.comparing((Rank r) -> r.dtb, Comparator.reverseOrder())
        );

        for (int i = 0; i < copied.size(); ++i) {
            Rank x = copied.get(i);
            double value = x.dtb;

            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
            }
            rank++;
        }

        for (int i = 0; i < ranks.size(); ++i) {
            Rank r = ranks.get(i);
            System.out.println(r.ma + " " + r.ten + " " + r.dtb + " " + r.xepLoai + " " + rankMap.get(r.dtb));
        }
        scanner.close();
    }

}
