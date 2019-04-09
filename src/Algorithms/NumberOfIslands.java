package Algorithms;

public class NumberOfIslands {
    private int result = 0;
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                dfs(grid, i, j);
                result++;
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        NumberOfIslands sol = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '0'},
                {'1', '1', '0'},
                {'0', '0', '1'},
        };
        System.out.println(sol.numIslands(grid));

    }
}
