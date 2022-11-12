package lr0;

import lr0.food.Eatable;
import lr0.food.UnsupportedProductException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Example1 {

    public static void main(String[] args) throws IOException, UnsupportedProductException, RefrigeratorStateException {
        final File refrigeratorFile = getFile("./out/refrigerator.csv", "./src/lr0/refrigerator.example.csv");

        final var io = new RefrigeratorIo();
        final var sandwichWriter = new SandwichWriter();

        final var input = new BufferedReader(new InputStreamReader(System.in));
        final var output = new BufferedWriter(new OutputStreamWriter(System.out));
        final var sandwichValidator = new SandwichValidator();
        final var refrigeratorValidator = new RefrigeratorValidator();

        var refrigerator = io.readFromFile(refrigeratorFile);
        var sandwich = new Sandwich();
        var exit = false;

        output.write("""
                Программа создания бутербродов
                Введите help для получения справки
                """);

        while (!exit) {
            output.newLine();
            output.write("> ");
            output.flush();

            var command = input.readLine().split("\s+");
            if (command.length == 0) {
                continue;
            }

            switch (command[0]) {
                case "show" -> {
                    if (command.length == 1) {
                        showSandwich(sandwich, output);
                        continue;
                    }
                    switch (command[1]) {
                        case "ref" -> showRefrigerator(refrigerator, output);
                        case "sw" -> showSandwich(sandwich, output);
                    }
                }
                case "open" -> openRefrigerator(refrigerator, output);
                case "close" -> closeRefrigerator(refrigerator, output);
                case "commit" -> {
                    if (validate(refrigerator, sandwich, refrigeratorValidator, sandwichValidator, output)) {
                        commit(refrigerator, sandwich, io, sandwichWriter, refrigeratorFile, output);
                        refrigerator = io.readFromFile(refrigeratorFile);
                        sandwich = new Sandwich();
                    }
                }
                case "reset" -> {
                    refrigerator = io.readFromFile(refrigeratorFile);
                    sandwich = new Sandwich();
                }
                case "put" -> {
                    if (command.length == 1) {
                        output.write("Пропущен обязательный аргумент itemNo");
                        continue;
                    }
                    int itemNo = Integer.parseInt(command[1]);
                    putItemNoToSandwich(refrigerator, sandwich, itemNo, output);
                }
                case "exit" -> exit = true;
                case "help" -> showHelp(command, output);
                default -> output.write("Неизвестная команда\n");
            }
        }
    }

    private static void commit(
        Refrigerator refrigerator,
        Sandwich sandwich,
        RefrigeratorIo refrigeratorIo,
        SandwichWriter sandwichWriter,
        File refrigeratorFile,
        BufferedWriter output
    ) throws IOException, RefrigeratorStateException {
        commitRefrigerator(refrigerator, refrigeratorIo, output, refrigeratorFile);
        commitSandwich(sandwich, sandwichWriter, output);
    }

    private static boolean validate(
        Refrigerator refrigerator,
        Sandwich sandwich,
        RefrigeratorValidator refrigeratorValidator,
        SandwichValidator sandwichValidator,
        BufferedWriter output
    ) throws IOException {
        var errors = new ArrayList<ValidationError>();

        errors.addAll(sandwichValidator.validate(sandwich));
        errors.addAll(refrigeratorValidator.validate(refrigerator));

        for (var error: errors) {
            output.write(error.getMessage());
            output.newLine();
        }

        if (errors.size() > 0) {
            output.write("Невозможно сохранить бутерброд\n");
            return false;
        }

        return true;
    }

    private static void showHelp(String[] command, BufferedWriter output) throws IOException {
        switch (command.length) {
            case 2:
            case 3:
                switch (command[1]) {
                    case "show"   -> showHelpShow(command, output);
                    case "open"   -> showHelpOpen(output);
                    case "close"  -> showHelpClose(output);
                    case "commit" -> showHelpCommit(output);
                    case "reset"  -> showHelpReset(output);
                    case "put"    -> showHelpPut(output);
                    case "exit"   -> showHelpExit(output);
                    case "help"   -> showHelpMain(output);
                    default       -> showHelpMain(output);
                }
                break;
            case 1:
            default:
                showHelpMain(output);
                break;
        }
    }

    private static void putItemNoToSandwich(Refrigerator refrigerator, Sandwich sandwich, int itemNo, BufferedWriter output) throws IOException, UnsupportedProductException {
        if (!refrigerator.isOpen()) {
            output.write("Сначала откройте холодильник (команда open)\n");
            return;
        }

        var iterator = refrigerator.getContent().iterator();
        Eatable itemByNo = null;
        for (var i = 1; i <= itemNo; i++) {
            if (!iterator.hasNext()) {
                itemByNo = null;
                break;
            }
            itemByNo = iterator.next();
        }

        if (itemByNo == null) {
            output.write("Продукт с порядковым номером " + itemNo + " не найден");
            return;
        }

        var part = refrigerator.getItemPart(itemByNo.getName());

        sandwich.add(part);

        output.write("Добавлен ингридиент " + part.getName() + ": " + part.getQuantity() + ' ' + part.getUnit());
    }

    private static void commitRefrigerator(Refrigerator refrigerator, RefrigeratorIo refrigeratorIo, BufferedWriter output, File file) throws IOException, RefrigeratorStateException {
        if (!file.setWritable(true)) {
            output.write("Файл " + file.getPath() + " недоступен для записи");
        }

        refrigeratorIo.writeToFile(refrigerator, file);

        output.write("Холодильник сохранен в " + file.getPath() + "\n");
    }

    private static void commitSandwich(Sandwich sandwich, SandwichWriter sandwichWriter, BufferedWriter output) throws IOException {
        File file = null;
        for (var i = 0; i < 1000; i++) {
            file = new File("./out/sandwich_" + i);
            if (!file.exists() && file.createNewFile() && file.setWritable(true)) {
                break;
            } else {
                file = null;
            }
        }

        if (file == null) {
            output.write("Не удалось создать файл для сохранения бутерброда после 1000 попыток");
            output.newLine();

            return;
        }

        sandwichWriter.writeToFile(sandwich, file);

        output.write("Бутерброд сохранен в " + file.getPath() + "\n");
    }

    private static void showSandwich(Sandwich sandwich, BufferedWriter output) throws IOException {
        output.write("Бутерброд:\n");

        var i = 1;
        for (var item: sandwich.getRecipe()) {
            output.write(i + ". " + item.getName() + ":\t" + item.getQuantity() + ' ' + item.getUnit() + "\n");
            i++;
        }
    }

    private static void showRefrigerator(Refrigerator refrigerator, BufferedWriter output) throws IOException {
        if (!refrigerator.isOpen()) {
            output.write("Сначала откройте холодильник (команда open)\n");
            return;
        }

        output.write("Холодильник:\n");

        var i = 1;
        for (var item: refrigerator.getContent()) {
            output.write(i + ". " + item.getName() + ":\t" + item.getQuantity() + ' ' + item.getUnit() + "\n");
            i++;
        }
    }

    private static void openRefrigerator(Refrigerator refrigerator, BufferedWriter output) throws IOException {
        if (!refrigerator.isOpen()) {
            refrigerator.open();
            output.write("Холодильник успешно открыт\n");
        } else {
            output.write("Холодильник уже открыт\n");
        }
    }

    private static void closeRefrigerator(Refrigerator refrigerator, BufferedWriter output) throws IOException {
        if (refrigerator.isOpen()) {
            refrigerator.close();
            output.write("Холодильник успешно закрыт\n");
        } else {
            output.write("Холодильник уже закрыт\n");
        }
    }

    private static File getFile(String path, String pathToExample) throws IOException {
        var refrigeratorFile = new File(path);
        if (refrigeratorFile.exists() && !refrigeratorFile.canRead()) {
            try {
                if (!refrigeratorFile.createNewFile()) {
                    throw new RuntimeException("Файл уже существует, но с ним что-то не так");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (!refrigeratorFile.exists() && pathToExample != null) {
            Files.copy(Path.of(pathToExample), Path.of(path));

            return getFile(path, null);
        }

        if (!refrigeratorFile.setReadable(true)) {
            throw new RuntimeException("Файл не читается");
        }
        return refrigeratorFile;
    }

    private static void showHelpExit(BufferedWriter output) throws IOException {
        output.write("Завершить работу и выйти\n");
    }

    private static void showHelpPut(BufferedWriter output) throws IOException {
        output.write("Положить часть продукта на бутерброд\n");
    }

    private static void showHelpReset(BufferedWriter output) throws IOException {
        output.write("Отменить все несохраненные изменения и обнулить бутерброд\n");
    }

    private static void showHelpCommit(BufferedWriter output) throws IOException {
        output.write("Сохранить состояние холодильника и бутерброда\n");
    }

    private static void showHelpClose(BufferedWriter output) throws IOException {
        output.write("Закрыть холодильник\n");
    }

    private static void showHelpOpen(BufferedWriter output) throws IOException {
        output.write("Открыть холодильник\n");
    }

    private static void showHelpShow(String[] command, BufferedWriter output) throws IOException {
        switch (command.length) {
            case 3:
                switch (command[2]) {
                    case "ref" -> showHelpShowRefrigerator(output);
                    case "sw"  -> showHelpShowSandwich(output);
                    default    -> showHelpShowMain(output);
                }
                break;
            case 2:
                showHelpShowMain(output);
                break;
        }
    }

    private static void showHelpShowRefrigerator(BufferedWriter output) throws IOException {
        output.write("Показать содержимое холодильника\n");

    }

    private static void showHelpShowSandwich(BufferedWriter output) throws IOException {
        output.write("Показать будерброд\n");

    }

    private static void showHelpShowMain(BufferedWriter output) throws IOException {
        output.write("""
                Доступные команды
                \tshow ref - показать содержимое холодильника
                \tshow sw - показать будерброд
                """);

    }

    private static void showHelpMain(BufferedWriter output) throws IOException {
        output.write("""
                Доступные команды
                \tshow - показать содержимое, введите help show для получения подробностей
                \topen - открыть холодильник
                \tclose - закрыть холодильник
                \tcommit - сохранить состояние холодильника и бутерброда
                \treset - отменить все несохраненные изменения и обнулить бутерброд
                \tput <[0-9]+> - положить часть продукта на бутерброд
                \texit - завершить работу и выйти
                \thelp - показать эту справку
                """);
    }
}
