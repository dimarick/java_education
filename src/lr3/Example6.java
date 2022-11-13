package lr3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Example6 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Input number: ");
        var line = in.nextLine();
        int value;

        try {
            value = Integer.parseInt(line);
        } catch (Throwable e) {
            System.out.println("Значение имеет неверный формат: " + e.getMessage());

            return;
        }

        if (value <= 0) {
            System.out.println("Значение должно быть положительным");

            return;
        }

        if (value > (Integer.MAX_VALUE - 2) / 5 + 1) {
            System.out.println("Значение слишком велико");

            return;
        }

        int[] array = IntStream.range(0, value).map(i -> i * 5 + 2).toArray();

        System.out.println("array is " + Arrays.toString(array));

        in.close();
    }
}
