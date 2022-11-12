package lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Input dow: ");
        var dow = in.nextLine();

        System.out.println("Input month: ");
        var month = in.nextLine();

        System.out.println("Input day: ");
        var day = in.nextLine();

        System.out.println("today " + dow + ' ' + month + ' ' + day);
        in.close();
    }
}
