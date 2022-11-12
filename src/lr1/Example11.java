package lr1;

import java.util.Calendar;
import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Input name: ");
        var name = in.nextLine();

        System.out.println("Input birth year: ");
        var year = in.nextInt();

        var currentYear = Calendar.getInstance().get(Calendar.YEAR);

        System.out.println("At and of current year " + name + " will have " + (currentYear - year) + " full years old");

        in.close();
    }
}
