package lr1;

import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Input first number: ");
        var first = in.nextBigDecimal();
        System.out.println("Input second number: ");
        var second = in.nextBigDecimal();

        System.out.println("Sum is " + first.add(second).toPlainString());
        in.close();
    }
}
