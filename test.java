import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println("Two");
// The division is ok
        int value = 10 / 2;
        System.out.println("One");
// divide by zero and error encountered in here
        try{
            value = 10 / 0;
        }catch(ArithmeticException e){
            System.out.println(e);
        }
//this line is executed
        System.out.println("Let's go!");
    }
}

