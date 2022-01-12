package dynamicprogramming.medium;

/**
 * @author arnab.ray
 * @created on 12/01/22
 */
// #62
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] lookup = new int[m][n];
        lookup[0][0] = 1;
        for (int i = 1; i < m; i++)
            lookup[i][0] = 1;
        for (int j = 1; j < n; j++)
            lookup[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                lookup[i][j] = lookup[i - 1][j] + lookup[i][j - 1];
            }
        }

        return lookup[m - 1][n - 1];
    }
}
