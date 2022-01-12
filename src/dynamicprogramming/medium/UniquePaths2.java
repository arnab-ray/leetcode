package dynamicprogramming.medium;

/**
 * @author arnab.ray
 * @created on 12/01/22
 */
// #63
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] lookup = new int[m][n];
        if(obstacleGrid[0][0] == 1)
            return 0;

        lookup[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1 || lookup[i - 1][0] == 0)
                lookup[i][0] = 0;
            else
                lookup[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1 || lookup[0][j - 1] == 0)
                lookup[0][j] = 0;
            else
                lookup[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    lookup[i][j] = 0;
                else
                    lookup[i][j] = lookup[i - 1][j] + lookup[i][j - 1];
            }
        }

        return lookup[m - 1][n - 1];
    }
}
