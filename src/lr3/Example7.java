package lr3;

import java.util.Arrays;
import java.util.Collections;

public class Example7 {
    public static void main(String[] args) {
        var array = new Character[10];

        for (char i = 0; i < 10; i++) {
            array[i] = (char)('a' + i * 2);
        }

        System.out.println(Arrays.toString(array));
        Collections.reverse(Arrays.asList(array));
        System.out.println(Arrays.toString(array));
    }
}
