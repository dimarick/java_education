package lr1;

import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Input name: ");
        var name = in.nextLine();

        System.out.println("Input age: ");
        var age = in.nextInt();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        in.close();
    }
}
