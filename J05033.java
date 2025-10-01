import java.util.*;

public class J05033 {
    static class Point {
        int h, m, s;
        public Point(int h, int m, int s){
            this.h = h;
            this.m = m;
            this.s = s;
        }
        @Override
        public String toString() {
            return h + " " + m + " " + s;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T, hour, minute, second;
        T = scanner.nextInt();
        ArrayList<Point> timeSort = new ArrayList<>();

        while (T-- > 0) {
            hour = scanner.nextInt();
            minute = scanner.nextInt();
            second = scanner.nextInt();
            timeSort.add(new Point(hour, minute, second));
        }
        timeSort.sort(
                Comparator.comparing((Point p) -> p.h)
                        .thenComparing((Point p) -> p.m)
                        .thenComparing((Point p) -> p.s)
        );
        timeSort.forEach(System.out::println);
        scanner.close();
    }
}
