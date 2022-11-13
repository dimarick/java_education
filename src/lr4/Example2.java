package lr4;

public class Example2 {
    public static void main(String[] args) {
        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < y; x++) {
                System.out.print("▒▒");
            }
            System.out.println();
        }
    }
}
