package lr3;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Example5v2 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Введите число чисел для сложения: ");
        var value = in.nextInt();

        System.out.println("Сумма " + IntStream.rangeClosed(1, Integer.MAX_VALUE).filter(i -> i % 5 == 2 || i % 3 == 1).limit(value).sum());

        in.close();
    }
}
