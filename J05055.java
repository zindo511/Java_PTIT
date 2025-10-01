import java.util.*;

public class J05055 {
    static class Vdv {
        private String ma, ten, ns, begin, end;
        private int uuTien;

        public Vdv(String ma, String ten, String ns, String begin, String end, int uuTien) {
            this.ma = ma;
            this.ten = ten;
            this.ns = ns;
            this.begin = begin;
            this.end = end;
            this.uuTien = uuTien;
        }
    }

    static int giay(String s) {
        String[] p = s.split(":");
        int hour = Integer.valueOf(p[0]),
                minute = Integer.valueOf(p[1]),
                second = Integer.valueOf(p[2]);
        return hour * 3600 + minute * 60 + second;
    }
    static int cal(String begin, String end) {
        String[] p1 = begin.split(":"),
                p2 = end.split(":");

        return giay(end) - giay(begin);
    }

    static String in(int hour, int minute, int second) {
        return String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second);
    }
    static String trans(int second) {
        int hour = second / 3600;
        second %= 3600;
        int minute = second / 60;
        second %= 60;
        return in(hour, minute, second);
    }

    static int chuyen(String ns) {
        int tuoi = 2021 - Integer.valueOf(ns.split("/")[2]);
        if (tuoi >= 32) return 3;
        if (tuoi >= 25) return 2;
        if (tuoi >= 18) return 1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vdv> vdvs = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            String ma = "VDV" + String.format("%02d", i);
            String ten = scanner.nextLine(),
                    ns = scanner.nextLine(),
                    begin = scanner.nextLine(),
                    end = scanner.nextLine();
            int uuTien = chuyen(ns);
            vdvs.add(new Vdv(ma, ten, ns, begin, end, uuTien));
        }

        ArrayList<Vdv> copied = new ArrayList<>(vdvs);
        copied.sort(
                Comparator.comparing((Vdv vdv) -> cal(vdv.begin, vdv.end) - vdv.uuTien)
        );

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < copied.size(); ++i) {
            Vdv vdv = copied.get(i);
            int value = cal(vdv.begin, vdv.end) - vdv.uuTien;

            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
            }
            rank++;
        }
        for (int i = 0; i < vdvs.size(); ++i) {
            Vdv vdv = vdvs.get(i);
            int real = cal(vdv.begin, vdv.end),
                    xepHang = real - vdv.uuTien;
            System.out.println(vdv.ma + " " + vdv.ten + " " + trans(real) + " " + trans(vdv.uuTien) + " "
                    + trans(xepHang) + " " + rankMap.get(xepHang));
        }
        scanner.close();
    }
}
