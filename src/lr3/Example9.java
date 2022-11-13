package lr3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Example9 {
    public static void main(String[] args) {
        var random = new Random();

        var array = IntStream.rangeClosed(0, 10).map(i -> random.nextInt(0, 10)).toArray();
        var results = new ArrayList<Integer>(10);
        var min = Integer.MAX_VALUE;

        for (var i = 0; i < array.length; i++) {
            int value = array[i];
            if (value < min) {
                results.clear();
                results.add(i);
                min = value;
            } else if (value == min) {
                results.add(i);
            }
        }

        System.out.println(Arrays.toString(results.stream().map(i -> i + " -> " + array[i]).toArray()));
    }
}
