import java.io.*;
import java.util.*;

public class J07005 {
    public static void main(String[] args){
        Map<Integer, Integer> map = new TreeMap<>();
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("DATA.IN"));

            while (dis.available() > 0) {
                int x = dis.readInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            dis.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }
}
