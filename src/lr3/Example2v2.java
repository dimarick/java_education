package lr3;

import java.util.Locale;
import java.util.Scanner;

public class Example2v2 {

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Введите день недели: ");
        var value = in.nextLine().toLowerCase(Locale.of("RU_ru"));

        if ("понедельник".equals(value)) {
            System.out.println(1);
        } else if ("вторник".equals(value)) {
            System.out.println(2);
        } else if ("среда".equals(value)) {
            System.out.println(3);
        } else if ("четверг".equals(value)) {
            System.out.println(4);
        } else if ("пятница".equals(value)) {
            System.out.println(5);
        } else if ("суббота".equals(value)) {
            System.out.println(6);
        } else if ("воскресенье".equals(value)) {
            System.out.println(7);
        } else {
            System.out.println("Неверное значение");
        }
    }
}
