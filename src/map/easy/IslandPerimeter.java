package map.easy;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            int n = grid[i].length;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0)
                        count++;
                    if (j == 0 || grid[i][j - 1] == 0)
                        count++;
                    if (i == m - 1 || grid[i + 1][j] == 0)
                        count++;
                    if (j == n - 1 || grid[i][j + 1] == 0)
                        count++;
                }
            }
        }

        return count;
    }
}
