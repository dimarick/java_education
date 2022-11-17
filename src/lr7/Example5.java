package lr7;

public class Example5 {
    public static void main(String[] args) {
        System.out.println(new BaseClass3("test 2"));
        System.out.println(new InheritedClass3("test 2", 'X'));
        System.out.println(new InheritedClass4("test 2", 42));
        var x = (BaseClass3) new InheritedClass4("test 2", 42);
        System.out.println(x);
    }
}

class BaseClass3 {
    protected String text;

    public BaseClass3(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "BaseClass3{" + "text='" + text + '\'' + '}';
    }
}

class InheritedClass3 extends BaseClass3 {
    protected char character;

    public InheritedClass3(String text, char character) {
        super(text);
        this.character = character;
    }

    @Override
    public String toString() {
        return "InheritedClass3{" + "character=" + character + ", text='" + text + '\'' + '}';
    }
}

class InheritedClass4 extends BaseClass3 {
    protected int value;

    public InheritedClass4(String text, int value) {
        super(text);
        this.value = value;
    }

    @Override
    public String toString() {
        return "InheritedClass4{" + "value=" + value + ", text='" + text + '\'' + '}';
    }
}
