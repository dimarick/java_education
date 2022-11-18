package lr8.Task1;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Example10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter out = null;
        try {
// Создание потоков
            br = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("/tmp/MyFile1.txt"), StandardCharsets.UTF_8));
            out = new PrintWriter("/tmp/MyFile2.txt", StandardCharsets.UTF_8);
// Переписывание информации из одного файла в другой
            int lineCount = 0;
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                out.println(lineCount + ": " + s);
            }
        } catch (IOException e) {
            System.out.println("Ошибка !!!!!!!!");
        } finally {
            if (br != null) {
                br.close();
            }
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}
