import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05068 {
    static class Quote {
        private String orderCode, production;
        private long unitPrice, tax, total;

        public Quote(String orderCode, String production, long unitPrice, long tax, long total) {
            this.orderCode = orderCode;
            this.production = production;
            this.unitPrice = unitPrice;
            this.tax = tax;
            this.total = total;
        }
        @Override
        public String toString() {
            return orderCode + " " + production + " " + unitPrice + " " + tax + " " + total;
        }
    }
    static String company(String s) {
        String x = s.substring(s.length() - 2);
        if (x.equals("BP")) return "British Petro";
        if (x.equals("ES")) return "Esso";
        if (x.equals("SH")) return "Shell";
        if (x.equals("CA")) return "Castrol";
        if (x.equals("MO")) return "Mobil";
        return "Trong Nuoc";
    }

    static long price(String s){
        String x = s.substring(0, 1);
        if (x.equals("X")) return 128000;
        if (x.equals("D")) return 11200;
        return 9700;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Quote> quotes = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String orderCode = scanner.next();
            int number = scanner.nextInt();
            String production = company(orderCode);
            long unitPrice = price(orderCode);

            long tax;
            String s = orderCode.substring(0, 1);
            String name = orderCode.substring(orderCode.length() - 2);
            if (name.equals("TN")) tax = 0;
            else if (s.equals("X")) tax = number * unitPrice * 3 / 100;
            else if (s.equals("D")) tax = number * unitPrice * 7 / 200;
            else if (s.equals("N")) tax = number * unitPrice * 2 / 100;
            else tax = 0;

            long total = number * unitPrice + tax;
            quotes.add(new Quote(orderCode, production, unitPrice, tax, total));
        }
        quotes.sort(
                Comparator.comparing((Quote quote) -> quote.total, Comparator.reverseOrder())
        );
        quotes.forEach(System.out::println);
        scanner.close();
    }
}
