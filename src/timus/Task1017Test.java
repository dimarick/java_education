package timus;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1017">see task</a>
 */
public class Task1017Test {
    public static void main(String[] args) {
        var start = System.nanoTime();

        for (short i = 500; i <= 500; i++) {
            long result = Task1017.getStairsVariants(i);
            System.out.println(i + " = \t" + result);
        }

        System.out.println(((double)(System.nanoTime() - start) / 1000) + " us");
    }
}
