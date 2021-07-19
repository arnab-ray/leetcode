package dfs.medium;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    if (dfsUtil(i, j, grid, visited)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfsUtil(int startX, int startY, int[][] grid, boolean[][] visited) {
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        visited[startX][startY] = true;

        boolean isClosed = startX > 0 && startY > 0 && startX < grid.length - 1 && startY < grid[0].length - 1;

        for (int i = 0; i < 4; i++) {
            int x_ = startX + x[i];
            int y_ = startY + y[i];
            if (x_ >= 0 && x_ < grid.length && y_ >= 0 && y_ < grid[0].length && grid[x_][y_] == 0 && !visited[x_][y_]) {
                isClosed = dfsUtil(x_, y_, grid, visited) && isClosed;
            }
        }

        return isClosed;
    }
}
