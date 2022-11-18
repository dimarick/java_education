package lr6;

import java.util.Arrays;

public class Example7 {
    public static void main(String[] args) {
        System.out.println("array " + Arrays.toString(mapToInt(new Character[]{'0', '1', '2', '3', '4'})));
    }

    private static int[] mapToInt(Character[] array) {
        return Arrays.stream(array).mapToInt((c) -> (int) c).toArray();
    }
}
