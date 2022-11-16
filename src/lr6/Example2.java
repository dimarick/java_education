package lr6;

class SerialProvider {
    private static int value = 0;

    public static int next() {
        return value++;
    }
}

public class Example2 {

    public static void main(String[] args) {
        System.out.println(SerialProvider.next());
        System.out.println(SerialProvider.next());
        System.out.println(SerialProvider.next());
        System.out.println(SerialProvider.next());
    }
}
