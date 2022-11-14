package lr5;

class Char {
    private char value;

    Char(char value) {
        this.value = value;
    }

    public int getCode() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void print() {
        System.out.println(value);
    }
}

public class Example1 {
    public static void main(String[] args) {
        var c = new Char('A');
        c.print();
        System.out.println(c.getCode());
        c.setValue('B');
        c.print();
        System.out.println(c.getCode());
    }
}
