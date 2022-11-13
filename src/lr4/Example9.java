package lr4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Example9 {
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
        var alphabet = new ArrayList<Character>(200);
        Function<Integer, Character> toChar = c -> (char) c.intValue();

        alphabet.addAll(IntStream.rangeClosed('0', '9').boxed().map(toChar).toList());
        alphabet.addAll(IntStream.rangeClosed('a', 'z').boxed().map(toChar).toList());
        alphabet.addAll(IntStream.rangeClosed('A', 'Z').boxed().map(toChar).toList());
        alphabet.addAll(IntStream.rangeClosed('а', 'я').boxed().map(toChar).toList());
        alphabet.addAll(IntStream.rangeClosed('А', 'Я').boxed().map(toChar).toList());
        alphabet.addAll(" ,.;:'\"@!#$%^&*()-_=+~`|/".chars().boxed().map(toChar).toList());

        var result = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            var c = text.charAt(i);
            result[i] = caesarEncryptChar(alphabet, key, c);
        }

        return String.valueOf(result);
    }

    private static char caesarEncryptChar(ArrayList<Character> alphabet, int key, char c) {
        if (!alphabet.contains(c)) {
            return c;
        }

        var e = alphabet.indexOf(c) + key;

        while (e < 0) {
            e = alphabet.size() + e;
        }

        e = e % alphabet.size();

        return alphabet.get(e);
    }
}
