package lr2;

import java.math.BigInteger;
import java.util.Scanner;

public class Example2 {

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        var value = in.nextBigInteger();

        if (value.mod(new BigInteger("5")).equals(new BigInteger("2")) && value.mod(new BigInteger("7")).equals(new BigInteger("1"))) {
            System.out.println("Это число удовлетворяет условиям");
        } else {
            System.out.println("Это число НЕ удовлетворяет условиям");
        }

        in.close();
    }
}
