package lr4;

import java.util.Random;

public class Example6 {
    public static void main(String[] args) {
        Integer[][] array = new Integer[11][23];
        Integer[][] array2 = new Integer[11][22];
        Integer[][] array3 = new Integer[10][23];
        var random = new Random();

        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 23; x++) {
                array[y][x] = random.nextInt('a', 'z');
            }
        }

        var rowToRemove = random.nextInt(0, 11);
        var columnToRemove = random.nextInt(0, 23);

        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 23; x++) {
                array2[y][x > columnToRemove ? x - 1 : x] = array[y][x];
            }
        }

        for (int y = 0; y < 11; y++) {
            System.arraycopy(array[y], 0, array3[y > rowToRemove ? y - 1 : y], 0, 23);
        }

        Integer[][][] integers = {array, array2, array3};
        for (var a : integers) {
            for (var row : a) {
                for (var column : row) {
                    System.out.print(Character.toChars(column));
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
