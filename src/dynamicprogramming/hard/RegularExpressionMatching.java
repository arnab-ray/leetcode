package dynamicprogramming.hard;

import java.util.Arrays;

public class RegularExpressionMatching {
    // '.' Matches any single character.
    // '*' Matches zero or more of the preceding element.

    /**
     * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     * 3, If p.charAt(j) == '*':
     *    here are two sub conditions:
     *                1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
     *                2   if p.charAt(j-1) == s.charAt(i) or p.charAt(i-1) == '.':
     *                               dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
     *                            or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
     *                            or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int j = 2; j <= n; j++)
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int[] dp_ : dp)
            Arrays.fill(dp_, -1);

        return isMatchUtil(s, m - 1, p, n - 1, dp) == 1;
    }

    private int isMatchUtil(String s, int m, String p, int n, int[][] dp) {
        if (m < 0 && n < 0)
            return 1;

        if (m >= 0 && n < 0)
            return 0;

        if (m < 0) {
            for (int i = 1; i <= n; i++) {
                if (p.charAt(i) == '*')
                    return 1;
            }

            return 0;
        }

        if (dp[m][n] == -1) {
            if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '.')
                dp[m][n] = isMatchUtil(s, m - 1, p, n - 1, dp);
            else if (n > 1 && p.charAt(n) == '*') {
                dp[m][n] = dp[m][n - 1];
                if (s.charAt(m) == p.charAt(n - 1) || p.charAt(n - 1) == '.') {
                    dp[m][n] = dp[m - 1][n] | dp[m][n];
                }
            } else {
                dp[m][n] = 0;
            }
        }

        return dp[m][n];
    }
}
