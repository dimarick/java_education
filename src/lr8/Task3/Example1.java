package lr8.Task3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Example1 {
    public static void main(String[] args) throws IOException {
        final var file1 = new File("./src/lr8/Task3/text1.txt");
        final var file2 = new File("/tmp/text2.txt");

        if (file2.createNewFile()) {
            System.out.println("created new output file");
        }

        try (
            final var inputStream = new FileInputStream(file1);
            final var dataReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            final var outputStream = new BufferedOutputStream(new FileOutputStream(file2));
            final var dataWriter = new PrintWriter(outputStream);
            final var resultInputStream = new BufferedInputStream(new FileInputStream(file2));
            final var resultReader = new DataInputStream(resultInputStream)
        ) {
            System.out.println("Start copying...");

            var vowels = "аеёиоуыэюя";

            for (var i = 1; ; i++) {
                var line = dataReader.readLine();

                if (line == null) {
                    break;
                }

                if (line.length() < 1) {
                    continue;
                }

                final var words = line.split("[^\\p{L}]+");
                for (var word : words) {
                    final var firstChar = word.substring(0, 1).toLowerCase(Locale.of("ru_RU"));
                    if (vowels.contains(firstChar)) {
                        continue;
                    }

                    dataWriter.print(i);
                    dataWriter.print(". ");
                    dataWriter.println(word);
                }
            }

            dataWriter.flush();

            System.out.println(new String(resultReader.readAllBytes()));

            System.out.println("done");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);

            throw e;
        }
    }
}
