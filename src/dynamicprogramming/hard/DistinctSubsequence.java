package dynamicprogramming.hard;

// #115
public class DistinctSubsequence {
    private int numDistinctUtil(String s, int m, String t, int n, int[][] dp) {
        if (n == 0)
            return 1;
        if (m == 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];

        if (s.charAt(m - 1) != t.charAt(n - 1)) {
            dp[m][n] = numDistinctUtil(s, m - 1, t, n, dp);
        } else {
            dp[m][n] = numDistinctUtil(s, m - 1, t, n, dp) + numDistinctUtil(s, m - 1, t, n - 1, dp);
        }

        return dp[m][n];
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = -1;

        return numDistinctUtil(s, m, t, n, dp);
    }
}
