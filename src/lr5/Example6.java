package lr5;

class IntRange {
    private int min;
    private int max;

    public IntRange(int min, int max) {
        setRangeImpl(min, max);
    }

    public IntRange(int max) {
        setRangeImpl(0, max);
    }

    public void setRange(int min, int max) {
        setRangeImpl(min, max);
    }

    public void setRange(int max) {
        setRangeImpl(0, max);
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    private void setRangeImpl(int min, int max) {
        this.min = Math.min(min, max);
        this.max = Math.max(min, max);
    }
}

public class Example6 {
    public static void main(String[] args) {
        var r = new IntRange(5, 1);
        System.out.println(r.getMin());
        System.out.println(r.getMax());
        System.out.println();

        var r2 = new IntRange(2, 7);
        System.out.println(r2.getMin());
        System.out.println(r2.getMax());
        System.out.println();

        var r3 = new IntRange(7);
        System.out.println(r3.getMin());
        System.out.println(r3.getMax());
        System.out.println();

        var r4 = new IntRange(-5);
        System.out.println(r4.getMin());
        System.out.println(r4.getMax());
        System.out.println();

        r4.setRange(4, 1);
        System.out.println(r4.getMin());
        System.out.println(r4.getMax());
        System.out.println();

        r4.setRange(1, 3);
        System.out.println(r4.getMin());
        System.out.println(r4.getMax());
        System.out.println();

        r4.setRange(9);
        System.out.println(r4.getMin());
        System.out.println(r4.getMax());
        System.out.println();

        r4.setRange(-19);
        System.out.println(r4.getMin());
        System.out.println(r4.getMax());
        System.out.println();
    }
}
