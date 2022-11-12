package lr0.food;

public class UnsupportedProductException extends Exception {
    public UnsupportedProductException(String name) {
        super("Продукт '" + name + "' не поддерживается");
    }
}
