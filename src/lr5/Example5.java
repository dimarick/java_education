package lr5;

class LimitedRangeIntContainer {
    private int value;

    public LimitedRangeIntContainer(int value) {
        this.value = limitRange(value);
    }

    public LimitedRangeIntContainer() {
        this.value = 0;
    }

    public void setValue(int value) {
        this.value = limitRange(value);
    }

    public void setValue() {
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    private int limitRange(int value) {
        return Math.min(value, 100);
    }

}

public class Example5 {
    public static void main(String[] args) {
        System.out.println(new LimitedRangeIntContainer().getValue());
        System.out.println(new LimitedRangeIntContainer(-1).getValue());
        System.out.println(new LimitedRangeIntContainer(42).getValue());
        System.out.println(new LimitedRangeIntContainer(101).getValue());
        LimitedRangeIntContainer limitedRangeIntContainer = new LimitedRangeIntContainer(101);
        limitedRangeIntContainer.setValue();
        System.out.println(limitedRangeIntContainer.getValue());
        limitedRangeIntContainer.setValue(42);
        System.out.println(limitedRangeIntContainer.getValue());
        limitedRangeIntContainer.setValue(100);
        System.out.println(limitedRangeIntContainer.getValue());
        limitedRangeIntContainer.setValue(101);
        System.out.println(limitedRangeIntContainer.getValue());
    }
}
