package lr0.food;

public interface Saucable extends Eatable {
    Saucable drop() throws UnsupportedProductException;
}
