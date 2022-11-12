package lr1;

import java.math.BigDecimal;
import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Input a number: ");
        var num = in.nextBigDecimal();
        var first = num.add(new BigDecimal(-1));
        var second = num;
        var third = num.add(new BigDecimal(1));
        var fourth = first.add(second).add(third).pow(2);

        System.out.println(
            first.toPlainString() + ' ' +
            second.toPlainString() + ' ' +
            third.toPlainString() + ' ' +
            fourth.toPlainString()
        );
        in.close();
    }
}
