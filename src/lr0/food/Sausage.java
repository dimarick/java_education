package lr0.food;

public class Sausage extends AbstractSlicable {
    private final static int SLICE_SIZE = 50;

    public Sausage(int quantity) {
        super(quantity, SLICE_SIZE);
    }

    public String getName() {
        return "колбаса";
    }

    public String getUnit() {
        return "г";
    }
}
