package lr3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Example3 {
    static private class FibonacciIterator implements Iterator<BigInteger> {
        final private BigInteger[] prev = {new BigInteger("0"), new BigInteger("1")};
        private Integer current;
        final private Integer max;

        public FibonacciIterator(Integer max) {
            this.max = max;
            this.current = 0;
        }

        public boolean hasNext() {
            return current <= max;
        }

        public BigInteger next() {
            current++;

            if (current == 1) {
                return new BigInteger("1");
            }

            var result = prev[0].add(prev[1]);

            prev[0] = prev[1];
            prev[1] = result;

            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        var in = new Scanner(System.in);

        int maxAllowed = (int)Math.pow(2, 30);
        System.out.println("Введите число от 0 до " + maxAllowed + ": ");

        var value = in.nextInt();

        if (value < 0 || value > maxAllowed) {
            System.out.println("Число вне разрешенного диапазона");

            return;
        }

        var writer = new BufferedWriter(new PrintWriter(System.out));

        System.out.println("Фибоначчи с итератором   = ");
        dumpIntegers(writer, fibonacci(value));

        writer.flush();
        writer.close();
    }

    private static Iterator<BigInteger> fibonacci(int value) {
        return new FibonacciIterator(value);
    }

    private static void dumpIntegers(BufferedWriter writer, Iterator<BigInteger> items) throws IOException {
        if (!items.hasNext()) {
            return;
        }

        var i = 0;

        do {
            writer.write(items.next().toString());

            if (!items.hasNext()) {
                break;
            } else {
                writer.write(',');
                if (i >= 10) {
                    writer.write('\n');
                    i = 0;
                }

                i++;
            }
        } while (true);
    }
}