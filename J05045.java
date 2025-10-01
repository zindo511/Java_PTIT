import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J05045 {
    static class Employee {
        String codeEmployee, fullName;
        long benefit, mainSalary, pay, remaining;

        public Employee(String codeEmployee, String fullName, long benefit, long mainSalary, long pay, long remaining) {
            this.codeEmployee = codeEmployee;
            this.fullName = fullName;
            this.benefit = benefit;
            this.mainSalary = mainSalary;
            this.pay = pay;
            this.remaining = remaining;
        }

        public long getSalary() {
            return mainSalary + benefit;
        }

        public String getCodeEmployee() {
            return codeEmployee;
        }

        public String toString() {
            return codeEmployee + " " + fullName + " " + benefit + " " + mainSalary + " " + pay + " " + remaining;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            scanner.nextLine();
            String codeEmployee = "NV" + String.format("%02d", i);
            String fullName = scanner.nextLine(), position = scanner.nextLine();
            long basicSalary = scanner.nextLong(), numDay =scanner.nextLong();

            long benefit = benefits(position);
            long mainSalary = basicSalary * numDay;
            long pay = advance(benefit, mainSalary);
            long remaining = benefit + mainSalary - pay;
            employees.add(new Employee(codeEmployee, fullName, benefit, mainSalary, pay, remaining));
        }

        employees.sort(
                Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())
                        .thenComparing(Employee::getCodeEmployee)
        );

        employees.forEach(System.out::println);
        scanner.close();
    }
    static long benefits(String position) {
        if (position.equals("GD")) return 500;
        if (position.equals("PGD")) return 400;
        if (position.equals("TP")) return 300;
        if (position.equals("KT")) return 250;
        return 100;
    }

    static long advance(long benefit, long mainSalary) {
        long pay;
        double temp = (benefit + mainSalary) * 2.0 / 3;
        if (temp < 25000) {
            pay = Math.round(temp / 1000) * 1000;
        }
        else pay = 25000;
        return pay;
    }
}