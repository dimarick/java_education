package lr2;

import java.math.BigInteger;
import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        var value = in.nextBigInteger();

        if (value.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) {
            System.out.println("Это число делится на 3");
        } else {
            System.out.println("Это число НЕ делится на 3");
        }

        in.close();
    }
}
