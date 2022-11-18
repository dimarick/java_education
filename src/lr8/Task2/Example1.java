package lr8.Task2;

import java.io.*;

public class Example1 {
    public static void main(String[] args) throws IOException {
        final var file1 = new File("/tmp/MyFile1.txt");
        final var file2 = new File("/tmp/MyFile2.txt");

        if (file1.createNewFile()) {
            System.out.println("created new input file");
        }

        if (file2.createNewFile()) {
            System.out.println("created new output file");
        }

        try (
            final var inputStream1 = new BufferedInputStream(new FileInputStream(file1));
            final var dataReader1 = new DataInputStream(inputStream1);
            final var inputStream2 = new BufferedInputStream(new FileInputStream(file2));
            final var dataReader2 = new DataInputStream(inputStream2);

            final var outputStream1 = new BufferedOutputStream(new FileOutputStream(file1));
            final var dataWriter1 = new DataOutputStream(outputStream1);
            final var outputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
            final var dataWriter2 = new DataOutputStream(outputStream2)
        ) {
            dataWriter1.writeUTF("Привет,\n");
            dataWriter1.writeUTF("мир!\n");
            dataWriter1.writeDouble(42.123);
            dataWriter1.writeDouble(1.0/3);
            dataWriter1.writeDouble(Math.PI);
            dataWriter1.writeDouble(Math.E);
            dataWriter1.writeDouble(Math.pow(Math.PI, Math.E));
            dataWriter1.flush();

            System.out.println("Start copying...");

            for (var i = 0; i < 2; i++) {
                final var line = dataReader1.readUTF();
                System.out.print(line);
                dataWriter2.writeUTF(line);
            }

            for (var i = 0; i < 5; i++) {
                final var number = dataReader1.readDouble();
                System.out.println(number);
                dataWriter2.writeDouble(number);
            }
            dataWriter2.flush();

            System.out.println("done");
            System.out.println("Start testing...");

            for (var i = 0; i < 2; i++) {
                final var line = dataReader2.readUTF();
                System.out.print(line);
            }

            for (var i = 0; i < 5; i++) {
                final var number = dataReader2.readDouble();
                System.out.println(number);
            }

            System.out.println("done");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);

            throw e;
        }
    }
}
