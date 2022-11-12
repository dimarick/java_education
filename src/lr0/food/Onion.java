package lr0.food;

public class Onion extends AbstractSlicable {
    final private static int SLICE_SIZE = 10;

    public Onion(int quantity) {
        super(quantity, SLICE_SIZE);
    }

    public String getName() {
        return "лук";
    }

    public String getUnit() {
        return "г";
    }
}
