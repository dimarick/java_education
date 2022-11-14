package lr0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SandwichWriter {
    public void writeToFile(Sandwich sandwich, File file) throws IOException {
        var writer = new BufferedWriter(new FileWriter(file));

        var i = 1;
        for (var item : sandwich.getRecipe()) {
            writer.write(i + ". " + item.getName() + ": " + item.getQuantity() + ' ' + item.getUnit() + "\n");
            i++;
        }

        writer.flush();
        writer.close();
    }
}
