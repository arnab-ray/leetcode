package dfs.medium;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxVal = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    AtomicInteger val = new AtomicInteger();
                    dfsUtil(i, j, grid, visited, val);
                    maxVal = Math.max(maxVal, val.get());
                }
            }
        }

        return maxVal;
    }

    private void dfsUtil(int startX, int startY, int[][] grid, boolean[][] visited, AtomicInteger val) {
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        visited[startX][startY] = true;
        val.getAndIncrement();
        for (int i = 0; i < 4; i++) {
            int x_ = startX + x[i];
            int y_ = startY + y[i];
            if (x_ >= 0 && x_ < grid.length && y_ >= 0 && y_ < grid[0].length && grid[x_][y_] == 1 && !visited[x_][y_]) {
                dfsUtil(x_, y_, grid, visited, val);
            }
        }
    }
}
