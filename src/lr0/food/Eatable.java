package lr0.food;

public interface Eatable {
    String getName();

    String getUnit();

    int getQuantity();

    static Eatable create(String name, int quantity) throws UnsupportedProductException {
        return switch (name) {
            case "колбаса" -> new Sausage(quantity);
            case "хлеб" -> new Bread(quantity);
            case "сыр" -> new Cheese(quantity);
            case "лук" -> new Onion(quantity);
            case "кетчуп" -> new Ketchup(quantity);
            case "майонез" -> new Mayonnaise(quantity);
            default -> throw new UnsupportedProductException(name);
        };
    }
}
