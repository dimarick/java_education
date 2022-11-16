package lr6;

import java.math.BigInteger;

public class Example4 {
    public static void main(String[] args) {
        System.out.println(doubleFactorialUsingLoop(0));
        System.out.println(doubleFactorialUsingLoop(1));
        System.out.println(doubleFactorialUsingLoop(2));
        System.out.println(doubleFactorialUsingLoop(5));
        System.out.println(doubleFactorialUsingLoop(17));
        System.out.println(doubleFactorialUsingLoop(29));
        System.out.println(doubleFactorialUsingLoop(101));
        System.out.println(doubleFactorialUsingLoop(301));
        System.out.println(doubleFactorialUsingLoop(50000));
        System.out.println(doubleFactorialUsingRecursion(0));
        System.out.println(doubleFactorialUsingRecursion(1));
        System.out.println(doubleFactorialUsingRecursion(2));
        System.out.println(doubleFactorialUsingRecursion(5));
        System.out.println(doubleFactorialUsingRecursion(17));
        System.out.println(doubleFactorialUsingRecursion(29));
        System.out.println(doubleFactorialUsingRecursion(101));
        System.out.println(doubleFactorialUsingRecursion(301));
        //А вот тут мы падаем, потому что джава как ни странно не поддерживает tail call optimization
        System.out.println(doubleFactorialUsingRecursion(50000));
    }

    private static BigInteger doubleFactorialUsingLoop(int n) {
        var result = BigInteger.ONE;

        while (n > 0) {
            result = BigInteger.valueOf(n).multiply(result);
            n -= 2;
        }

        return result;
    }

    private static BigInteger doubleFactorialUsingRecursion(int n) {
        if (n <= 0) {
            return BigInteger.ONE;
        }

        return doubleFactorialUsingRecursion(n - 2).multiply(BigInteger.valueOf(n));
    }
}
