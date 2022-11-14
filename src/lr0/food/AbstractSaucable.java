package lr0.food;

import java.util.Random;

public abstract class AbstractSaucable extends AbstractEatable implements Saucable {
    private final int maxDropSize;
    private final int minDropSize;

    public AbstractSaucable(int quantity, int minDropSize, int maxDropSize) {
        super(quantity);
        this.minDropSize = minDropSize;
        this.maxDropSize = maxDropSize;
    }

    public Saucable drop() throws UnsupportedProductException {
        int sliceSize = new Random().nextInt(minDropSize, maxDropSize);

        var result = Math.min(this.getQuantity(), sliceSize);

        this.setQuantity(this.getQuantity() - result);

        var eatable = Eatable.create(this.getName(), result);
        if (eatable instanceof Saucable) {
            return (Saucable) eatable;
        }

        throw new UnsupportedProductException(this.getName());
    }
}
