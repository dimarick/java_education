package lr6;

import java.util.Arrays;

public class Example8 {
    public static void main(String[] args) {
        System.out.println("avg " + avg(new int[]{1, 2, 3, 4}));
        System.out.println("avg " + avg(new int[]{}));
    }

    private static double avg(int[] array) {
        return Arrays.stream(array).average().orElse(Double.NaN);
    }
}
