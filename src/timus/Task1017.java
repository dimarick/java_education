package timus;

import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1017">see task</a>
 */
public class Task1017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        short value = in.nextShort();

        System.out.println(getStairsVariants(value));
        in.close();
    }

    static long getStairsVariants(short value) {
        long[][] cache = new long[32][501];
        short value2 = (short) (value * 2);
        long result = 0;

        for (short n = 2; n*n+n <= value2; n++) {
            result += getStairsVariants(n, value, cache);
        }

        return result;
    }

    static long getStairsVariants(short columns, short value, long[][] cache) {
        long result = 0;

        if (columns == 2) {
            return getMaxFirstStep(columns, value);
        }

        if (cache[columns][value] != 0) {
            return cache[columns][value];
        }

        int maxStep = getMaxFirstStep(columns, value);

        for (short k = 1; k <= maxStep; k++) {
            result += getStairsVariants((short) (columns - 1), (short) (value - columns * k), cache);
        }

        cache[columns][value] = result;

        return result;
    }

    private static short getMaxFirstStep(short columns, short value) {
        return (short)((value-(1+columns)*columns/2)/columns + 1);
    }
}
