package dfs.medium;

public class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxVal = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    maxVal = Math.max(maxVal, dfsUtil(i, j, grid, visited));
                }
            }
        }

        return maxVal;
    }

    private int dfsUtil(int startX, int startY, int[][] grid, boolean[][] visited) {
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        visited[startX][startY] = true;

        int count = 1;

        for (int i = 0; i < 4; i++) {
            int x_ = startX + x[i];
            int y_ = startY + y[i];
            if (x_ >= 0 && x_ < grid.length && y_ >= 0 && y_ < grid[0].length && grid[x_][y_] == 1 && !visited[x_][y_]) {
                count += dfsUtil(x_, y_, grid, visited);
            }
        }

        return count;
    }
}
