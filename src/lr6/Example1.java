package lr6;

class CharAndTextContainer {
    private char character;
    private String text;

    public void setValue(char character) {
        this.character = character;
    }

    public void setValue(String text) {
        this.text = text;
    }

    public void setValue(char[] characters) {
        this.text = String.valueOf(characters);
    }

    public char getCharacter() {
        return character;
    }

    public String getText() {
        return text;
    }
}

public class Example1 {
    public static void main(String[] args) {
        final var container = new CharAndTextContainer();

        container.setValue("Hello world");
        System.out.println("text is " + container.getText());

        container.setValue('H');
        System.out.println("char is " + container.getCharacter() + ", text is " + container.getText());

        container.setValue(new char[]{'H', 'e', 'l', 'l', 'o'});
        System.out.println("char is " + container.getCharacter() + ", text is " + container.getText());
    }
}
