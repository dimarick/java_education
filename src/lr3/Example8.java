package lr3;

import java.util.Arrays;

public class Example8 {
    public static void main(String[] args) {
        var vowels = Arrays.asList('A', 'E', 'I', 'O', 'U');
        var consonant = new char[26 - vowels.size()];

        int i = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!vowels.contains(c)) {
                consonant[i++] = c;
            }
        }

        System.out.println(Arrays.toString(consonant));
    }
}
