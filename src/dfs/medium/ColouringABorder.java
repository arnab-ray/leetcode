package dfs.medium;

public class ColouringABorder {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};

        if (grid[r0][c0] != color)
            dfsUtil(grid, visited, dirX, dirY, r0, c0, color);

        return grid;
    }

    private void dfsUtil(int[][] grid, boolean[][] visited, int[] dirX, int[] dirY, int r0, int c0, int colour) {
        int count = 0;
        int oldColour = grid[r0][c0];
        visited[r0][c0] = true;
        grid[r0][c0] = colour;

        for (int i = 0; i < 4; i++) {
            int x = r0 + dirX[i];
            int y = c0 + dirY[i];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                if (grid[x][y] == oldColour) {
                    count++;
                    dfsUtil(grid, visited, dirX, dirY, x, y, colour);
                } else if (grid[x][y] == colour && visited[x][y]) {
                    count++;
                }
            }
        }

        if (count == 4)
            grid[r0][c0] = oldColour;
    }
}
