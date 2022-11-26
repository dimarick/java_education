package timus;

import java.util.Arrays;
import java.util.Scanner;

class Point {
    public int i;
    public int x;
    public int y;

    public Point(int i, int x, int y) {
        this.i = i;
        this.x = x;
        this.y = y;
    }
}

public class Task1207 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) {
            return;
        }

        int values = in.nextInt();

        if (values == 0) {
            System.out.print(0);
            return;
        }

        Point[] points = new Point[values];

        for (int i = 0; i < values; i++) {
            points[i] = new Point(i + 1, in.nextInt(), in.nextInt());
        }

        int[] medianPoints = getMedianPoints(points);
        System.out.println(medianPoints[0] + " " + medianPoints[1]);
    }

    static int[] getMedianPoints(Point[] points) {
        Point lowestPoint = points[0];

        for (int i = 1; i < points.length; i++) {
            if (points[i].y < lowestPoint.y) {
                lowestPoint = points[i];
            }
        }

        Point finalLowestPoint = lowestPoint;
        Arrays.sort(points, (a, b) -> compare(a, b, finalLowestPoint));

        return new int[]{lowestPoint.i, points[points.length / 2].i};
    }

    private static int compare(Point a, Point b, Point lowestPoint) {
        Point a1 = new Point(a.i, a.x - lowestPoint.x, a.y - lowestPoint.y);
        Point b1 = new Point(b.i, b.x - lowestPoint.x, b.y - lowestPoint.y);

        if (a1.x == 0 && a1.y == 0) {
            return -1;
        }

        if (b1.x == 0 && b1.y == 0) {
            return 1;
        }

        byte quarterA = getQuarter(a1);
        byte quarterB = getQuarter(b1);

        if (quarterA != quarterB) {
            return Byte.compare(quarterA, quarterB);
        }

        double tanA = (double) a1.y / a1.x;
        double tanB = (double) b1.y / b1.x;

        return Double.compare(tanA, tanB);
    }

    private static byte getQuarter(Point point) {
        if (point.y >= 0 && point.x >= 0) {
            return 1;
        }

        return 2;
    }
}
