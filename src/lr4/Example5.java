package lr4;

import java.util.Random;

public class Example5 {
    public static void main(String[] args) {
        Integer[][] array = new Integer[11][23];
        Integer[][] array2 = new Integer[23][11];
        var random = new Random();

        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 23; x++) {
                array[y][x] = random.nextInt('a', 'z');
            }
        }

        for (int y = 0; y < 23; y++) {
            for (int x = 0; x < 11; x++) {
                array2[y][x] = array[x][y];
            }
        }

        for (var row: array) {
            for (var column: row) {
                System.out.print(Character.toChars(column));
            }
            System.out.println();
        }

        for (var row: array2) {
            for (var column: row) {
                System.out.print(Character.toChars(column));
            }
            System.out.println();
        }
    }
}
