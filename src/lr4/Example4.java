package lr4;

public class Example4 {
    public static void main(String[] args) {
        Character[][] array = new Character[11][23];

        for (int y = 1; y <= 11; y++) {
            for (int x = 1; x <= 23; x++) {
                array[y - 1][x - 1] = x / y >= 23 / 11 ? '2' : ' ';
            }
        }

        for (var row : array) {
            for (var column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
}
