package lr0;

import lr0.food.Eatable;

import java.util.*;

public class Sandwich {
    private final Deque<Eatable> content;

    public Sandwich() {
        this.content = new LinkedList<>();
    }

    public void add(Eatable item) {
        content.add(item);
    }

    public Deque<Eatable> getRecipe() {
        return this.content;
    }
}
