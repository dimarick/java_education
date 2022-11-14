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
        final var sandwichValidator = new SandwichValidator();
        final var refrigeratorValidator = new RefrigeratorValidator();

        var refrigerator = io.readFromFile(refrigeratorFile);
        var sandwich = new Sandwich();
        var exit = false;

        System.out.println("""
            Программа создания бутербродов
            Введите help для получения справки
            """);

        while (!exit) {
            System.out.print("> ");

            var command = input.readLine().split("\s+");
            if (command.length == 0) {
                continue;
            }

            switch (command[0]) {
                case "show" -> {
                    if (command.length == 1) {
                        showRefrigerator(refrigerator);
                        continue;
                    }
                    switch (command[1]) {
                        case "ref" -> showRefrigerator(refrigerator);
                        case "sw" -> showSandwich(sandwich);
                    }
                }
                case "open" -> openRefrigerator(refrigerator);
                case "close" -> closeRefrigerator(refrigerator);
                case "commit" -> {
                    if (validate(refrigerator, sandwich, refrigeratorValidator, sandwichValidator)) {
                        commit(refrigerator, sandwich, io, sandwichWriter, refrigeratorFile);
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
                        System.out.println("Пропущен обязательный аргумент itemNo");
                        continue;
                    }
                    int itemNo = Integer.parseInt(command[1]);
                    putItemNoToSandwich(refrigerator, sandwich, itemNo);
                }
                case "exit" -> exit = true;
                case "help" -> showHelp(command);
                default -> System.out.println("Неизвестная команда");
            }
        }

        input.close();
    }

    private static void commit(
        Refrigerator refrigerator,
        Sandwich sandwich,
        RefrigeratorIo refrigeratorIo,
        SandwichWriter sandwichWriter,
        File refrigeratorFile
    ) throws IOException, RefrigeratorStateException {
        commitRefrigerator(refrigerator, refrigeratorIo, refrigeratorFile);
        commitSandwich(sandwich, sandwichWriter);
    }

    private static boolean validate(
        Refrigerator refrigerator,
        Sandwich sandwich,
        RefrigeratorValidator refrigeratorValidator,
        SandwichValidator sandwichValidator
    ) {
        var errors = new ArrayList<ValidationError>();

        errors.addAll(sandwichValidator.validate(sandwich));
        errors.addAll(refrigeratorValidator.validate(refrigerator));

        for (var error : errors) {
            System.out.println(error.getMessage());
        }

        if (errors.size() > 0) {
            System.out.println("Невозможно сохранить бутерброд");
            return false;
        }

        return true;
    }

    private static void showHelp(String[] command) {
        switch (command.length) {
            case 2:
            case 3:
                switch (command[1]) {
                    case "show" -> showHelpShow(command);
                    case "open" -> showHelpOpen();
                    case "close" -> showHelpClose();
                    case "commit" -> showHelpCommit();
                    case "reset" -> showHelpReset();
                    case "put" -> showHelpPut();
                    case "exit" -> showHelpExit();
                    case "help" -> showHelpMain();
                    default -> showHelpMain();
                }
                break;
            case 1:
            default:
                showHelpMain();
                break;
        }
    }

    private static void putItemNoToSandwich(Refrigerator refrigerator, Sandwich sandwich, int itemNo) throws UnsupportedProductException {
        if (!refrigerator.isOpen()) {
            System.out.println("Сначала откройте холодильник (команда open)");
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
            System.out.println("Продукт с порядковым номером " + itemNo + " не найден");
            return;
        }

        var part = refrigerator.getItemPart(itemByNo.getName());

        sandwich.add(part);

        System.out.println("Добавлен ингридиент " + part.getName() + ": " + part.getQuantity() + ' ' + part.getUnit());
    }

    private static void commitRefrigerator(Refrigerator refrigerator, RefrigeratorIo refrigeratorIo, File file) throws IOException, RefrigeratorStateException {
        if (!file.setWritable(true)) {
            System.out.println("Файл " + file.getPath() + " недоступен для записи");
        }

        refrigeratorIo.writeToFile(refrigerator, file);

        System.out.println("Холодильник сохранен в " + file.getPath());
    }

    private static void commitSandwich(Sandwich sandwich, SandwichWriter sandwichWriter) throws IOException {
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
            System.out.println("Не удалось создать файл для сохранения бутерброда после 1000 попыток");

            return;
        }

        sandwichWriter.writeToFile(sandwich, file);

        System.out.println("Бутерброд сохранен в " + file.getPath());
    }

    private static void showSandwich(Sandwich sandwich) {
        System.out.println("Бутерброд:");

        var i = 1;
        for (var item : sandwich.getRecipe()) {
            System.out.println(i + ". " + item.getName() + ":\t" + item.getQuantity() + ' ' + item.getUnit());
            i++;
        }
    }

    private static void showRefrigerator(Refrigerator refrigerator) {
        if (!refrigerator.isOpen()) {
            System.out.println("Сначала откройте холодильник (команда open)");
            return;
        }

        System.out.println("Холодильник:");

        var i = 1;
        for (var item : refrigerator.getContent()) {
            System.out.println(i + ". " + item.getName() + ":\t" + item.getQuantity() + ' ' + item.getUnit());
            i++;
        }
    }

    private static void openRefrigerator(Refrigerator refrigerator) {
        if (!refrigerator.isOpen()) {
            refrigerator.open();
            System.out.println("Холодильник успешно открыт");
        } else {
            System.out.println("Холодильник уже открыт");
        }
    }

    private static void closeRefrigerator(Refrigerator refrigerator) {
        if (refrigerator.isOpen()) {
            refrigerator.close();
            System.out.println("Холодильник успешно закрыт");
        } else {
            System.out.println("Холодильник уже закрыт");
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

    private static void showHelpExit() {
        System.out.println("Завершить работу и выйти");
    }

    private static void showHelpPut() {
        System.out.println("Положить часть продукта на бутерброд");
    }

    private static void showHelpReset() {
        System.out.println("Отменить все несохраненные изменения и обнулить бутерброд");
    }

    private static void showHelpCommit() {
        System.out.println("Сохранить состояние холодильника и бутерброда");
    }

    private static void showHelpClose() {
        System.out.println("Закрыть холодильник");
    }

    private static void showHelpOpen() {
        System.out.println("Открыть холодильник");
    }

    private static void showHelpShow(String[] command) {
        switch (command.length) {
            case 3:
                switch (command[2]) {
                    case "ref" -> showHelpShowRefrigerator();
                    case "sw" -> showHelpShowSandwich();
                    default -> showHelpShowMain();
                }
                break;
            case 2:
                showHelpShowMain();
                break;
        }
    }

    private static void showHelpShowRefrigerator() {
        System.out.println("Показать содержимое холодильника");

    }

    private static void showHelpShowSandwich() {
        System.out.println("Показать будерброд");

    }

    private static void showHelpShowMain() {
        System.out.println("""
            Доступные команды
            \tshow ref - показать содержимое холодильника
            \tshow sw - показать будерброд
            """);

    }

    private static void showHelpMain() {
        System.out.println("""
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
