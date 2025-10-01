import java.util.Scanner;

public class J04009 {
    static class Point {
        private double x, y;

        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        public static double kc(Point a, Point b){
            return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
        }

        public static void check(Point a, Point b, Point c) {
            double Kc1 = kc(a, b),
                    Kc2 = kc(b, c),
                    Kc3 = kc(a, c);
            if (Kc1 + Kc2 <= Kc3 || Kc1 + Kc3 <= Kc2 || Kc2 + Kc3 <= Kc1)
                System.out.println("INVALID");
            else {
                double dientich = Math.sqrt((Kc1 + Kc2 + Kc3) * (Kc1 + Kc2 - Kc3) * (Kc2 + Kc3 - Kc1) * (Kc3 + Kc1 - Kc2));
                System.out.println(String.format("%.2f", dientich / 4));
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            double x1, x2, y1, y2, z1, z2;
            x1 = scanner.nextDouble();
            x2 = scanner.nextDouble();
            y1 = scanner.nextDouble();
            y2 = scanner.nextDouble();
            z1 = scanner.nextDouble();
            z2 = scanner.nextDouble();

            Point a = new Point(x1, x2),
                    b = new Point(y1, y2),
                    c = new Point(z1, z2);

            Point.check(a, b, c);
        }
        scanner.close();
    }
}
