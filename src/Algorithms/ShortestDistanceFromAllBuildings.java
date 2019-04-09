package Algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author skuang
 */
public class ShortestDistanceFromAllBuildings {
    private static final int[][] directions = new int[][] {
            new int[] {-1, 0},
            new int[] {1, 0},
            new int[] {0, 1},
            new int[] {0, -1}
    };
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] steps = new int[m][n];
        int[][] reach = new int[m][n];
        int buildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // found building, begin bfs to all '0's can be reached
                    bfs(grid, steps, reach, i, j);
                    // add this to total num of buildings
                    buildings++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reach[i][j] == buildings && min > steps[i][j]) min = steps[i][j];
            }
        }
        return min;
    }

    private void bfs(int[][] grid, int[][] steps, int[][] reach, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(row, col));
        visited[row][col] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int x = 0; x < size; x++) {
                Point curr = queue.poll();
                if (grid[curr.row][curr.col] == 0) {
                    // it's a valid empty land
                    reach[curr.row][curr.col] += 1;
                    steps[curr.row][curr.col] += step;
                }
                for (int[] dir : directions) {
                    int i = curr.row + dir[0];
                    int j = curr.col + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && grid[i][j] == 0) {
                        queue.offer(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }
    }

    public static class Point {
        int row;
        int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings sol = new ShortestDistanceFromAllBuildings();
        int[][] grid = new int[][] {
                new int[] {1,0,2,0,1},
                new int[] {0,0,0,0,0},
                new int[] {0,0,1,0,0}
        };

        System.out.println(sol.shortestDistance(grid));
    }
}
