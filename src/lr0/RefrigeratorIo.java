package lr0;

import lr0.food.Eatable;
import lr0.food.UnsupportedProductException;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RefrigeratorIo {
    final private Pattern csvPattern;

    /**
     * Почти как настоящий csv только без поддержки кавычек
     */
    public RefrigeratorIo() {
        this.csvPattern = Pattern.compile("(.*?[^\\\\])(,|$)\s*");
    }

    public Refrigerator readFromFile(File file) throws IOException, UnsupportedProductException {
        var reader = new BufferedReader(new FileReader(file));
        String line;

        var foodItems = new ArrayList<Eatable>();

        while ((line = reader.readLine()) != null) {
            var matcher = csvPattern.matcher(line);
            var tokens = matcher.results().map((r) -> r.group(1).replace("\\,", ","));
            var iterator = tokens.iterator();

            if (!iterator.hasNext()) {
                continue;
            }

            var name = iterator.next();

            if (!iterator.hasNext()) {
                continue;
            }

            var quantity = Integer.parseInt(iterator.next());
            foodItems.add(Eatable.create(name, quantity));
        }

        reader.close();

        return new Refrigerator(foodItems);
    }

    public void writeToFile(Refrigerator refrigerator, File file) throws RefrigeratorStateException, IOException {
        var writer = new BufferedWriter(new FileWriter(file));

        if (refrigerator.isOpen()) {
            throw new RefrigeratorStateException();
        }
        
        for (var item: refrigerator.getContent()) {
            writer.write(item.getName().replace(",", "\\,") + "," + item.getQuantity() + "\n");
        }

        writer.flush();
        writer.close();
    }
}
