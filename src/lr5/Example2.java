package lr5;
class CharRange {
    private final char from;
    private final char to;

    CharRange(char from, char to) {
        this.from = from;
        this.to = to;
    }

    public void printRange() {
        for (char c = from; c <= to; c++) {
            System.out.print(c);
        }

        System.out.println();
    }
}

public class Example2 {
    public static void main(String[] args) {
        new CharRange('F', 'X').printRange();
    }
}
