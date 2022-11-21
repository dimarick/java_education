package timus;

import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1048">see task</a>
 */
public class Task1048 {
    public static void main(String[] args) {
        int cursor = 0;

        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) {
            return;
        }

        int values = in.nextInt();

        if (values == 0) {
            System.out.print(0);
            return;
        }

        byte[] result = new byte[values + 1];
        byte base = '0';
        result[0] = '0';

        for (int i = 0; i <= values; i++) {
            byte[] row = in.nextLine().getBytes();

            if (row.length < 3) {
                continue;
            }

            result[cursor] = (byte)(row[0] + row[2] - base);
            byte overflow = 0;

            for (int j = 0; j <= cursor; j++) {
                result[cursor - j] += overflow;
                if (result[cursor - j] > '9') {
                    result[cursor - j] -= 10;
                    overflow = 1;
                } else {
                    break;
                }
            }

            if (cursor > 8192 && result[cursor] < '9') {
                System.out.write(result, 0, cursor);
                result[0] = result[cursor];
                cursor = 0;
            }

            cursor++;
        }

        System.out.write(result, 0, cursor);
    }
}
