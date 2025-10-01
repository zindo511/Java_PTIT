//import java.io.*;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.TreeMap;
//
//public class J07015 {
//    static boolean nt(int n) {
//        if (n < 2) return false;
//        for (int i = 2; i * i <= n; ++i) {
//            if (n % i == 0) return false;
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        Map<Integer, Integer> map = new TreeMap<>();
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
//            ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();
//            ois.close();
//            while (dis.available() > 0) {
//                int x = dis.readInt();
//                if (nt(x)) map.put(x, map.getOrDefault(x, 0) + 1);
//            }
//            dis.close();
//        }
//        catch (IOException e) {
//
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet())
//            System.out.println(entry.getKey() + " " + entry.getValue());
//    }
//}
