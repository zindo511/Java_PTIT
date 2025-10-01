import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class J07045 {
    static class LoaiPhong implements Comparable<LoaiPhong> {
        private final String kyHieu;
        private final String ten;
        private final String donGia;
        private final String phiPhucVu;

        public LoaiPhong(String s) {
            String[] parts = s.trim().split("\\s+");
            this.kyHieu = parts[0];
            this.ten = parts[1];
            this.donGia = parts[2];
            this.phiPhucVu = parts[3];
        }

        public String getTen() {
            return ten;
        }

        public int compareTo(LoaiPhong o) {
            return this.ten.compareTo(o.ten);
        }

        public String toString() {
            return kyHieu + " " + ten + " " + donGia + " " + phiPhucVu;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}
