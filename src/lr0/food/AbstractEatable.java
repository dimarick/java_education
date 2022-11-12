package lr0.food;

public abstract class AbstractEatable implements Eatable {
    private int quantity;

    public AbstractEatable(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return "";
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
