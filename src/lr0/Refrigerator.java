package lr0;

import lr0.food.Eatable;
import lr0.food.Saucable;
import lr0.food.Slicable;
import lr0.food.UnsupportedProductException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Refrigerator {
    private boolean open = false;
    private final Map<String, Eatable> content;

    public Refrigerator(Collection<Eatable> content) {
        this.content = new HashMap<>();

        for (var item : content) {
            this.content.put(item.getName(), item);
        }
    }

    public Collection<Eatable> getContent() {
        return content.values();
    }

    public Eatable getItem(String name) {
        return content.get(name);
    }

    private void removeItem(String name) {
        this.content.remove(name);
    }

    public Eatable getItemPart(String name) throws UnsupportedProductException {
        Eatable item = this.getItem(name);
        Eatable part;
        if (item instanceof Slicable) {
            part = ((Slicable) item).slice();
        } else if (item instanceof Saucable) {
            part = ((Saucable) item).drop();
        } else {
            throw new UnsupportedProductException(item.getName());
        }

        if (item.getQuantity() == 0) {
            this.removeItem(name);
        }

        return part;
    }

    public boolean isOpen() {
        return open;
    }

    public void open() {
        this.open = true;
    }

    public void close() {
        this.open = false;
    }
}
