import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class J07004 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("DATA.in"));
        ArrayList<Integer> numbers = new ArrayList<>();
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            numbers.add(x);
        }
        numbers.sort(
                Comparator.comparing((Integer x) -> x)
        );

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.size(); ++i) {
            map.put(numbers.get(i), map.getOrDefault(numbers.get(i), 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());


        scanner.close();
    }
}
