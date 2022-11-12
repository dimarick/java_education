package lr0.food;

public class Bread extends AbstractSlicable {
    final private static int SLICE_SIZE = 50;

    public Bread(int quantity) {
        super(quantity, SLICE_SIZE);
    }

    public String getName() {
        return "хлеб";
    }

    public String getUnit() {
        return "г";
    }
}
