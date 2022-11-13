package lr2;

import java.util.Scanner;

public class Example5 {

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        var value = in.nextInt();

        System.out.println("Это число содержит " + ((value / 1000) % 10) + " тысяч");

        in.close();
    }
}
