package lr3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Example4v2 {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        System.out.println("Input a first number:");
        var first = in.nextBigInteger();

        System.out.println("Input a second number:");
        var second = in.nextBigInteger();
        var min = first.min(second);
        var max = first.max(second);

        BigInteger one = new BigInteger("1");

        var writer = new BufferedWriter(new PrintWriter(System.out));

        for (var value = min; value.compareTo(max) <= 0; value = value.add(one)) {
            writer.write(value.toString());
            writer.newLine();
        }

        writer.flush();
        writer.close();
        in.close();
    }
}
