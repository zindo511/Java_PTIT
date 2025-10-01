import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07073 {
    static class Method {
        private String subjectCode, subject, theoryTeaching, practiceTeaching;
        private int num;

        public Method(String subjectCode, String subject, int num, String theoryTeaching, String practiceTeaching) {
            this.subjectCode = subjectCode;
            this.subject = subject;
            this.num = num;
            this.theoryTeaching = theoryTeaching;
            this.practiceTeaching = practiceTeaching;
        }

        public String getSubjectCode() {
            return subjectCode;
        }

        @Override
        public String toString() {
            return subjectCode + " " + subject + " " + num + " " + theoryTeaching + " " + practiceTeaching;
        }
    }
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(new File("MONHOC.in"));
            ArrayList<Method> methods = new ArrayList<>();
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= n; ++i) {
                String subjectCode = scanner.nextLine(),
                        subject = scanner.nextLine();
                int num = scanner.nextInt();
                scanner.nextLine();

                String theoryTeaching = scanner.nextLine(),
                        practiceTeaching = scanner.nextLine();
                if (!practiceTeaching.equals("Truc tiep")) {
                    methods.add(new Method(subjectCode, subject, num, theoryTeaching, practiceTeaching));
                }
            }
            methods.sort(
                    Comparator.comparing(Method::getSubjectCode)
            );
            methods.forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
