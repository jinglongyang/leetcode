package math;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/max-points-on-a-line/
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnLine {
    public static void main(String[] args) {
        Point[] points = {new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
        System.out.println(new MaxPointsOnLine().maxPoints(points));
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        if (points.length == 1) {
            return 1;
        }

        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int dup = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j].y == points[i].y && points[j].x == points[i].x) {
                    dup++;
                } else {
                    Double key = Double.MAX_VALUE;
                    if (points[j].y == points[i].y) {
                        key = 0.0;
                    } else if (points[j].x != points[i].x) {
                        key = (double) (points[j].y - points[i].y) / (points[j].x - points[i].x);
                    }
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + 1);
                    } else {
                        map.put(key, 1);
                    }
                }
            }
            if (map.size() == 0) {
                return Math.max(max, dup);
            }
            for (int tmp : map.values()) {
                max = Math.max(max, tmp + dup);
            }
        }
        return max;
    }

    private static class Point {
        int x;
        int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
