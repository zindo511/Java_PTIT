import java.util.Scanner;

public class J04002 {
    static class Rectangle {
        private int dai, rong;

        public Rectangle(int dai, int rong) {
            this.dai = dai;
            this.rong = rong;
        }

        public static int perimeter(Rectangle p){
            return (p.dai + p.rong) * 2;
        }

        public static int area(Rectangle p) {
            return p.dai * p.rong;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        x = scanner.nextInt();
        y = scanner.nextInt();
        String color = scanner.next();

        if (x > 0 && y > 0) {
            Rectangle p = new Rectangle(x, y);
            color = color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();
            System.out.print(Rectangle.perimeter(p) + " " + Rectangle.area(p) + " " + color);
        }
        else System.out.println("INVALID");
        scanner.close();

    }
}