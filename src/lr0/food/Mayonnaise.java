package lr0.food;

public class Mayonnaise extends AbstractSaucable {
    public Mayonnaise(int quantity) {
        super(quantity, 5, 8);
    }

    public String getName() {
        return "майонез";
    }

    public String getUnit() {
        return "г";
    }
}
