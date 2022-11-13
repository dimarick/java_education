package lr3;

import java.util.*;
import java.util.stream.IntStream;

public class Example10 {
    public static void main(String[] args) {
        var random = new Random();

        var array = IntStream
            .rangeClosed(0, random.nextInt(1, 100))
            .map(i -> random.nextInt(0, random.nextInt(1, 100)))
            .boxed()
            .toArray();

        System.out.println(Arrays.toString(array));

        Arrays.sort(array, Collections.reverseOrder());

        System.out.println(Arrays.toString(array));
    }
}
