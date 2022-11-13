package lr3;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Example4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Input a first number:");
        var first = in.nextInt();

        System.out.println("Input a second number:");
        var second = in.nextInt();
        var min = Math.min(first, second);
        var max = Math.max(first, second);

        IntStream.rangeClosed(min, max).forEach(System.out::println);

        in.close();
    }
}
