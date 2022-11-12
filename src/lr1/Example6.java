package lr1;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Input first name: ");
        var firstName = in.nextLine();

        System.out.println("Input last name: ");
        var lastName = in.nextLine();

        System.out.println("Input middle name: ");
        var middleName = in.nextLine();

        System.out.println("Hello: " + lastName + ' ' + firstName + ' ' + middleName);
        in.close();
    }
}
