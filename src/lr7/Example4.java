package lr7;

public class Example4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        var base = new BaseClass2('X');
        System.out.println("character: " + base.character);
        var cloneBase = base.clone();
        cloneBase.character = 'Y';
        System.out.println("character: " + base.character);
        System.out.println("character: " + cloneBase.character);

        var inherited = new InheritedClass2('X', "text");
        System.out.println("character: " + inherited.character + ", text: " + inherited.text);
        var cloneInherited = inherited.clone();
        cloneInherited.character = 'Y';
        System.out.println("character: " + inherited.character);
        System.out.println("character: " + cloneInherited.character + ", text is cloned: " + (cloneInherited.text != inherited.text));

        var finalObject = new FinalClass2('X', "text", 42);
        System.out.println("character: " + finalObject.character + ", text: " + finalObject.text + ", value: " + finalObject.value);
        var cloneFinal = finalObject.clone();
        cloneFinal.character = 'Y';
        cloneFinal.value = 43;
        System.out.println("character: " + finalObject.character + ", value: " + finalObject.value);
        System.out.println("character: " + cloneFinal.character + ", value: " + cloneFinal.value + ", text is cloned: " + (cloneFinal.text != finalObject.text));
    }
}

class BaseClass2 implements Cloneable {
    public char character;

    public BaseClass2(char character) {
        this.character = character;
    }

    @Override
    protected BaseClass2 clone() throws CloneNotSupportedException {
        return (BaseClass2) super.clone();
    }
}

class InheritedClass2 extends BaseClass2 {
    public String text;

    public InheritedClass2(char character, String text) {
        super(character);
        this.text = text;
    }

    @Override
    protected InheritedClass2 clone() throws CloneNotSupportedException {
        var result = (InheritedClass2) super.clone();
        result.text = new String(this.text);

        return result;
    }
}

final class FinalClass2 extends InheritedClass2 {
    public int value;

    public FinalClass2(char character, String text, int value) {
        super(character, text);
        this.value = value;
    }

    @Override
    protected FinalClass2 clone() throws CloneNotSupportedException {
        return (FinalClass2) super.clone();
    }
}
