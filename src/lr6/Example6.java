package lr6;

import java.util.Arrays;

public class Example6 {
    public static void main(String[] args) {
        System.out.println("array " + Arrays.toString(getFirstElements(2, new int[]{1, 2, 3, 4})));
        final var a1 = new int[]{1, 2, 3, 4};
        System.out.println("array is not same: " + (a1 != getFirstElements(4, a1)));
    }

    private static int[] getFirstElements(int n, int[] array) {
        return Arrays.stream(array).limit(n).toArray();
    }
}
