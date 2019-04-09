package Algorithms;

import java.util.Arrays;

/**
 * @author skuang
 */
public class GenerateMaze {
    public static int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static int[][] generateMaze(int N) {
        int n = N * 2 - 1;
        int[][] maze = new int[n][n];
        for (int[] row : maze) Arrays.fill(row, 1);
        maze[0][0] = 0;
        dfs(maze, 0, 0);
        return maze;
    }

    public static void dfs(int[][] maze, int i, int j) {
        int m = maze.length;
        int n = maze[0].length;
        for (int[] dir : directions) {
            int r = i + 2 * dir[0];
            int c = j + 2 * dir[1];
            if (r < 0 || r >= m || c < 0 || c >= n || maze[r][c] == 0) continue;
            maze[r][c] = 0;
            maze[i + dir[0]][j + dir[1]] = 0;
            if (r == m - 1 && c == n - 1) continue;
            dfs(maze, r, c);
        }

    }

    public static void main(String[] args) {
        int[][] maze = generateMaze(5);
        for (int[] row : maze) {
            System.out.println(Arrays.toString(row));
        }
    }
}
