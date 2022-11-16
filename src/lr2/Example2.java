package lr2;

import java.math.BigInteger;
import java.util.Scanner;

public class Example2 {

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        var value = in.nextBigInteger();

        if (value.mod(BigInteger.valueOf(5)).equals(BigInteger.valueOf(2)) && value.mod(BigInteger.valueOf(7)).equals(BigInteger.valueOf(1))) {
            System.out.println("Это число удовлетворяет условиям");
        } else {
            System.out.println("Это число НЕ удовлетворяет условиям");
        }

        in.close();
    }
}
