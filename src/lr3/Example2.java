package lr3;

import java.util.Locale;
import java.util.Scanner;

public class Example2 {

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Введите день недели: ");
        var value = in.nextLine().toLowerCase(Locale.of("RU_ru"));

        switch (value) {
            case "понедельник" -> System.out.println(1);
            case "вторник" -> System.out.println(2);
            case "среда" -> System.out.println(3);
            case "четверг" -> System.out.println(4);
            case "пятница" -> System.out.println(5);
            case "суббота" -> System.out.println(6);
            case "воскресенье" -> System.out.println(7);
            default -> System.out.println("Неверное значение");
        }
    }
}
