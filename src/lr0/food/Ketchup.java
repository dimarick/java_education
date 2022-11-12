package lr0.food;

public class Ketchup extends AbstractSaucable {
    public Ketchup(int quantity) {
        super(quantity, 8, 11);
    }

    public String getName() {
        return "кетчуп";
    }

    public String getUnit() {
        return "г";
    }
}
