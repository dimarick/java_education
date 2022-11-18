package lr6;

import java.util.Arrays;

public class Example10 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMinMax()));
        System.out.println(Arrays.toString(getMinMax(1, 2, -5, Integer.MAX_VALUE)));
    }

    private static int[] getMinMax(int... array) {
        if (array.length == 0) {
            return null;
        }

        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;

        for (var i : array) {
            if (i < min) {
                min = i;
            }

            if (i > max) {
                max = i;
            }
        }

        return new int[]{min, max};
    }
}
