package lr6;

import java.util.Arrays;

public class Example9 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayReverse(new char[]{'0', '1', '2', '3', '4'})));
        System.out.println(Arrays.toString(arrayReverse(new char[]{'0', '1', '3', '5'})));

        System.out.println(Arrays.toString(arrayReverse2(new char[]{'0', '1', '2', '3', '4'})));
        System.out.println(Arrays.toString(arrayReverse2(new char[]{'0', '1', '3', '5'})));
    }

    private static char[] arrayReverse(char[] chars) {
        for (var i = 0; i < chars.length / 2; i++) {
            var j = chars.length - 1 - i;
            var first = chars[i];
            chars[i] = chars[j];
            chars[j] = first;
        }

        return chars;
    }

    private static char[] arrayReverse2(char[] chars) {
        for (var i = 0; i < chars.length / 2; i++) {
            final var j = chars.length - 1 - i;
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }

        return chars;
    }
}
