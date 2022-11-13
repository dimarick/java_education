package lr2;

import java.util.Scanner;

public class Example4 {

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        var value = in.nextByte();

        if (value >= 5 && value <= 10) {
            System.out.println("Это число удовлетворяет условиям");
        } else {
            System.out.println("Это число НЕ удовлетворяет условиям");
        }

        in.close();
    }
}
