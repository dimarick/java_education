package lr3;

import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Input number from 1 to 7: ");
        var value = in.nextByte();

        switch (value) {
            case 1 -> System.out.println("Понедельниик");
            case 2 -> System.out.println("Вторник");
            case 3 -> System.out.println("Среда");
            case 4 -> System.out.println("Четверг");
            case 5 -> System.out.println("Пятница");
            case 6 -> System.out.println("Суббота");
            case 7 -> System.out.println("Воскресенье");
            default -> System.out.println("Неверное значение");
        }
    }
}
