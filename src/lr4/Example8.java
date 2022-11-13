package lr4;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        System.out.println("Введите ключ");

        var key = in.nextInt();
        in.nextLine();

        System.out.println("Введите текст");

        var text = in.nextLine();

        var encrypted = caesarEncrypt(key, text);

        System.out.println(encrypted);

        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");

            var answer = in.nextLine();

            if (answer.equalsIgnoreCase("y")) {
                var decrypted = caesarEncrypt(-key, encrypted);
                System.out.println(decrypted);
                break;
            } else if (answer.equalsIgnoreCase("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }

        in.close();
    }

    private static String caesarEncrypt(int key, String text) {
        var result = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            var c = text.charAt(i);
            result[i] = caesarEncryptChar(key, c);
        }

        return String.valueOf(result);
    }

    private static char caesarEncryptChar(int key, char c) {
        char e;
        e = caesarEncryptCharForRange(key, c, '0', '9');
        e = caesarEncryptCharForRange(key, e, 'a', 'z');
        e = caesarEncryptCharForRange(key, e, 'A', 'Z');
        e = caesarEncryptCharForRange(key, e, 'а', 'я');
        e = caesarEncryptCharForRange(key, e, 'А', 'Я');

        return e;
    }

    private static char caesarEncryptCharForRange(int key, char c, char from, char to) {
        if (c >= from && c <= to) {
            int base = c - from;
            int encrypted = base + key;
            while (encrypted < 0) {
                encrypted = to - from + 1 + encrypted;
            }

            encrypted = encrypted % (to - from + 1);

            return (char) (encrypted + from);
        }

        return c;
    }
}
