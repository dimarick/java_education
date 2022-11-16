package lr6;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Первый параметр введен чтобы гарантировать непустой список аргументов на этапе компиляции
 */
class Aggregate {
    static int min(int value1, int... values) {
        return mergeArgs(value1, values).min().orElse(Integer.MAX_VALUE);
    }
    static int max(int value1, int... values) {
        return mergeArgs(value1, values).max().orElse(Integer.MAX_VALUE);
    }
    static double average(int value1, int... values) {
        return mergeArgs(value1, values).average().orElse(Double.POSITIVE_INFINITY);
    }

    private static IntStream mergeArgs(int value1, int... values) {
        return Stream.of(new int[]{value1}, values).flatMapToInt((int... t) -> Arrays.stream(t));
    }
}

public class Example3 {
    public static void main(String[] args) {
        System.out.println(Aggregate.max(1, 0, 2));
        System.out.println(Aggregate.max(5, 0, 2));
        System.out.println(Aggregate.min(-1, 0, 2));
        System.out.println(Aggregate.min(1, 0, 2));
        System.out.println(Aggregate.average(1, 0, 4));
        System.out.println(Aggregate.average(6, 0, 4));
    }
}