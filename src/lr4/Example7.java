package lr4;

public class Example7 {
    public static void main(String[] args) {
        Character[][] array = new Character[11][23];

        var width = array[0].length;
        var height = array.length;
        var xOffset = 0;
        var yOffset = 0;

        while (true) {
            for (var x = xOffset; x < xOffset + width; x++) {
                array[yOffset][x] = '→';
            }

            height--;
            yOffset++;

            if (height == 0) {
                break;
            }

            for (var y = yOffset; y < yOffset + height; y++) {
                array[y][xOffset + width - 1] = '↓';
            }

            width--;

            if (width == 0) {
                break;
            }

            for (var x = xOffset + width; x >= xOffset; x--) {
                array[yOffset + height - 1][x] = '←';
            }

            height--;

            if (height == 0) {
                break;
            }

            for (var y = yOffset + height; y >= yOffset; y--) {
                array[y][xOffset] = '↑';
            }

            width--;
            xOffset++;
        }

        for (var row: array) {
            for (var column: row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
}
