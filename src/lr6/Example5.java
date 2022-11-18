package lr6;

public class Example5 {
    public static void main(String[] args) {
        for (var n : new int[]{1, 3, 101, 10001, Integer.MAX_VALUE}) {
            System.out.println("loop: " + squareSumUsingLoop(n) + ", recursion: " + squareSumUsingRecursion(n) + ", formula: " + squareSumUsingFormula(n));
        }
    }

    private static long squareSumUsingFormula(int n) {
        return n * (n + 1) * ((long) 2 * n + 1) / 6;
    }

    private static long squareSumUsingLoop(int n) {
        long result = 0;

        for (long i = 1; i <= n; i++) {
            result += i * i;
        }

        return result;
    }

    private static long squareSumUsingRecursion(int n) {
        if (n <= 0) {
            return 0;
        }

        try {
            return ((long) n * n) + squareSumUsingRecursion(n - 1);
        } catch (StackOverflowError e) {
            // do nothing
        }

        return squareSumUsingRecursion(n);
    }
}
