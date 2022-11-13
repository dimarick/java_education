package lr3;

import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Введите число чисел для сложения: ");
        var value = in.nextInt();
        int sum = 0;
        int count = 0;

        for (var i = 1; count < value; i++) {
            if (i % 5 == 2 || i % 3 == 1) {
                sum += i;
                count++;
            }
        }

        System.out.println("Сумма " + sum);

        in.close();
    }
}
