package timus;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Task1207Test {
    public static void main(String[] args) {
        int[][] pointsTest = {
            {0,0, 0,(int)1e6, (int)1e6,0, -2,(int)1e6-1},
            {0,0, 0,(int)-1e6, -3,(int)-1e6, -2,(int)-1e6-1},
            {0,0, 0,(int)1e6, -3,(int)1e6, -2,(int)1e6-1},
            {0,0, 0,(int)1e6, 1,(int)1e6, -2,(int)1e6-1},
            {1,0, 1,1, 0,0, 0,1},
            {0,0, (int)1e6+1,(int)1e6 / 2, (int)1e6,(int)1e6 / 2 - 1, 0,1},
            {0,0, (int)1e6, 0, (int)1e6, 1, (int)1e6, 2},
            {0,0, (int)1e6, 0, (int)1e6, 1, (int)1e6-1, -2},
            {0,0, 0,(int)1e6, 1,(int)1e6, (int)1e6-1, -2},
        };

        var rng = new Random(1);

        for (var i = 0; i <= 100; i++) {
            Point[] points;
            if (i >= pointsTest.length) {
                var n = rng.nextInt(4, 10000) & ~1;
                var p = new Point[n];

                for (var j = 0; j < n; j++) {
                    p[j] = new Point(j, rng.nextInt((int) -1e6, (int) 1e6), rng.nextInt((int) -1e6, (int) 1e6));
                }
                points = p;
            } else {
                var p = new Point[pointsTest[i].length / 2];
                for (var j = 0; j < pointsTest[i].length; j += 2) {
                    p[j / 2] = new Point(j / 2, pointsTest[i][j], pointsTest[i][j + 1]);
                }

                points = p;
            }

            int[] medianPoints = Task1207.getMedianPoints(Arrays.copyOf(points, points.length));
            int[] testResult = testPoints(points, medianPoints);

            if (testResult[0] != testResult[1]) {
                System.out.print(i + ". ");
                System.out.print("!!!!!");
                System.out.println(Arrays.toString(medianPoints) + " test " + Arrays.toString(testResult));
                System.out.println(Arrays.stream(points).map(p -> p.x + "," + p.y).toList());
            }
        }
    }

    static int[] testPoints(Point[] points, int[] medianPointIds) {
        Point[] medianPoints = new Point[]{points[medianPointIds[0]], points[medianPointIds[1]]};
        Arrays.sort(medianPoints, Comparator.comparingInt(a -> a.x));
        Point first = medianPoints[0];
        Point last = medianPoints[1];

        double k = (double)(last.y - first.y) / (last.x - first.x);
        double b = first.y - first.x * k;

        int[] result = new int[]{0, 0, 0};

        if (Double.isInfinite(k)) {
            for (var point : points) {
                if (point.x > last.x) {
                    result[0]++;
                }
                if (point.x < last.x) {
                    result[1]++;
                }
                if (point.x == last.x) {
                    result[2]++;
                }
            }
        } else {
            for (var point : points) {
                var y = Math.round((k * point.x + b) * 1e6) / 1e6;

                if (point.y > y) {
                    result[0]++;
                }
                if (point.y < y) {
                    result[1]++;
                }
                if (point.y == y) {
                    result[2]++;
                }
            }
        }

        return result;
    }
}
