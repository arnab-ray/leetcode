package greedy.medium;

public class MaxIncreaseKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int count = 0;
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int maxHeightAllowed = Math.min(rowMax[i], colMax[j]);
                if (maxHeightAllowed > grid[i][j]) {
                    count += maxHeightAllowed - grid[i][j];
                }
            }
        }

        return count;
    }
}
