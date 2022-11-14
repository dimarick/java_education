package lr0.food;

public class Cheese extends AbstractSlicable {
    private final static int SLICE_SIZE = 20;

    public Cheese(int quantity) {
        super(quantity, SLICE_SIZE);
    }

    public String getName() {
        return "сыр";
    }

    public String getUnit() {
        return "г";
    }
}
