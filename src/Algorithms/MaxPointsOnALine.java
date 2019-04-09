package Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skuang
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        int max = Integer.MIN_VALUE;
        double maxVal = (double) Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int duplicate = 1;
            Point p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y) duplicate++;
                else if (p1.x == p2.x) {
                    map.put(maxVal, map.getOrDefault(maxVal, 0) + 1);
                } else {
                    double slope = Math.abs((double) (p1.y - p2.y) / (double) (p1.x - p2.x));
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            for (Integer count : map.values()) max = Math.max(max, count + duplicate);
        }
        return max;
    }

    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(94911151, 94911150);
        points[2] = new Point(94911152, 94911151);
        MaxPointsOnALine sol = new MaxPointsOnALine();
        System.out.println(sol.maxPoints(points));
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
