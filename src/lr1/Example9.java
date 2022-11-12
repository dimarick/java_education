package lr1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Input month: ");
        var month = in.nextLine();

        System.out.println("Input days: ");
        var days = in.nextLine();

        System.out.println(month + " have " + days);
        in.close();
    }
}
