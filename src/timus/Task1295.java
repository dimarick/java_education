package timus;

import java.util.Scanner;

public class Task1295 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        in.close();

        int result = 1 + powInt(2, value) + powInt(3, value) + powInt(4, value);

        int count = 0;

        while (result % 10 == 0) {
            count++;
            result /= 10;
        }

        System.out.println(count);
    }

    private static int powInt(int b, int value) {
        int result = 1;

        for (int i = 0; i < value; i++) {
            result = (result * b) % 1000;
        }

        return result;
    }
}
