package lr5;

class TwoIntContainer {
    private final int value1;

    private final int value2;

    public TwoIntContainer() {
        this.value1 = 0;
        this.value2 = 0;
    }

    public TwoIntContainer(int value1) {
        this.value1 = value1;
        this.value2 = 0;
    }

    public TwoIntContainer(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }
}

public class Example3 {
    public static void main(String[] args) {
        var c1 = new TwoIntContainer(1, 2);
        var c2 = new TwoIntContainer(1);
        var c3 = new TwoIntContainer();
        System.out.println(c1.getValue1());
        System.out.println(c1.getValue2());
        System.out.println();

        System.out.println(c2.getValue1());
        System.out.println(c2.getValue2());
        System.out.println();

        System.out.println(c3.getValue1());
        System.out.println(c3.getValue2());
        System.out.println();
    }
}