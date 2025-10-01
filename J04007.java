import java.util.Scanner;

public class J04007 {
    public static void main(String[] args) {
        String codeEmployee = "00001", name, sex, birthday, address, codeTax, dateContract;
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        sex = scanner.nextLine();
        birthday = scanner.nextLine();
        address = scanner.nextLine();
        codeTax = scanner.nextLine();
        dateContract = scanner.nextLine();

        System.out.println(codeEmployee + " " + name + " " + sex + " " + birthday + " " + address + " " + codeTax + " " + dateContract);
        scanner.close();
    }
}
