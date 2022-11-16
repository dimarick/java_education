package lr2;

import java.math.BigInteger;
import java.util.Scanner;

public class Example3 {

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        var value = in.nextBigInteger();

        if (value.compareTo(BigInteger.valueOf(10)) >= 0 && value.mod(BigInteger.valueOf(4)).equals(BigInteger.ZERO)) {
            System.out.println("Это число удовлетворяет условиям");
        } else {
            System.out.println("Это число НЕ удовлетворяет условиям");
        }

        in.close();
    }
}
