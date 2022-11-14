package lr0.food;

public abstract class AbstractSlicable extends AbstractEatable implements Slicable {
    private final int sliceSize;

    public AbstractSlicable(int quantity, int sliceSize) {
        super(quantity);
        this.sliceSize = sliceSize;
    }

    public Slicable slice() throws UnsupportedProductException {
        var result = Math.min(this.getQuantity(), sliceSize);

        this.setQuantity(this.getQuantity() - result);

        var eatable = Eatable.create(this.getName(), result);
        if (eatable instanceof Slicable) {
            return (Slicable) eatable;
        }

        throw new UnsupportedProductException(this.getName());
    }
}
