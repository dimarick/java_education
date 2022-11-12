package lr1;

import java.util.Calendar;
import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Input your age at end of current year: ");
        var age = in.nextInt();

        var currentYear = Calendar.getInstance().get(Calendar.YEAR);

        System.out.println("Your birth year is " + (currentYear - age));
        in.close();
    }
}
