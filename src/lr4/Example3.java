package lr4;

public class Example3 {
    public static void main(String[] args) {
        Character[][] array = new Character[11][23];

        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 23; x++) {
                array[y][x] = '2';
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