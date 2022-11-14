package lr0.food;

public interface Slicable extends Eatable {
    Slicable slice() throws UnsupportedProductException;
}
