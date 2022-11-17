package lr7;

public class Example3 {
    public static void main(String[] args) {
        System.out.println(new BaseClass(42));
        System.out.println(new InheritedClass(42, 'F'));
        System.out.println(new FinalClass(42, 'F', "text"));

        var base = new BaseClass(42);
        var inherited = new InheritedClass(42, 'F');
        var finalObject = new FinalClass(42, 'F', "text");

        base.setValue(43);
        inherited.setValue(43, 'A');
        finalObject.setValue(43, 'A', "test text");

        System.out.println(base);
        System.out.println(inherited);
        System.out.println(finalObject);
    }
}

class BaseClass {
    protected int value;

    public BaseClass(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BaseClass{" + "value=" + value + '}';
    }
}

class InheritedClass extends BaseClass {
    public char character;

    public InheritedClass(int value, char character) {
        super(value);
        this.character = character;
    }

    public void setValue(int value, char character) {
        this.value = value;
        this.character = character;
    }

    @Override
    public String toString() {
        return "InheritedClass{" + "character=" + character + ", value=" + value + '}';
    }
}

final class FinalClass extends InheritedClass {
    public String text;

    public FinalClass(int value, char character, String text) {
        super(value, character);
        this.text = text;
    }

    public void setValue(int value, char character, String text) {
        this.value = value;
        this.character = character;
        this.text = text;
    }

    @Override
    public String toString() {
        return "FinalClass{" + "text='" + text + '\'' + ", character=" + character + ", value=" + value + '}';
    }
}
