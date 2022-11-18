package lr8.Task1;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Example9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
// Создание потоков для чтения и записи с нужной кодировкой
            br = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("/tmp/MyFile1.txt"), StandardCharsets.UTF_8));
            bw = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream("/tmp/MyFile2.txt"), StandardCharsets.UTF_8));
// Переписывание информации из одного файла в другой
            int lineCount = 0; // счетчик строк
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                bw.write(lineCount + ": " + s); // запись без перевода строки
                bw.newLine(); // принудительный переход на новую строку
            }
        } catch (IOException e) {
            System.out.println("Ошибка!!!!!!!!" + e);
        } finally {
            if (br != null) {
                br.close();
            }
            if (bw != null) {
                bw.flush();
                bw.close();
            }
        }
    }
}
