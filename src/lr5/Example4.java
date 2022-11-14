package lr5;

class IntAndCharContainer {
    private final int i;
    private final char c;

    public IntAndCharContainer(double initializer) {
        this.i = (int)((initializer - (int)initializer) * 100);
        this.c = (char)((int)initializer % Character.MAX_VALUE + 1);
    }

    public IntAndCharContainer() {
        this.i = 0;
        this.c = 'A';
    }

    public IntAndCharContainer(char c) {
        this.i = 0;
        this.c = c;
    }

    public IntAndCharContainer(int i) {
        this.i = i;
        this.c = 'A';
    }

    public IntAndCharContainer(int i, char c) {
        this.i = i;
        this.c = c;
    }

    public int getI() {
        return i;
    }

    public char getC() {
        return c;
    }
}

public class Example4 {
    public static void main(String[] args) {
        var c = new IntAndCharContainer(70.15242);
        System.out.println(c.getC());
        System.out.println(c.getI());
        System.out.println();
        var c1 = new IntAndCharContainer();
        System.out.println(c1.getC());
        System.out.println(c1.getI());
        System.out.println();
        var c2 = new IntAndCharContainer('Z');
        System.out.println(c2.getC());
        System.out.println(c2.getI());
        System.out.println();
        var c3 = new IntAndCharContainer(115, 'Z');
        System.out.println(c3.getC());
        System.out.println(c3.getI());
        System.out.println();
        var c4 = new IntAndCharContainer(115);
        System.out.println(c4.getC());
        System.out.println(c4.getI());
        System.out.println();
    }
}
