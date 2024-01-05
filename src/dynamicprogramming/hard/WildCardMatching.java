package dynamicprogramming.hard;

import java.util.Arrays;

// #44
public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
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
        for (int[] dp_row : dp) {
            Arrays.fill(dp_row, -1);
        }

        return isMatchUtil(s, m - 1, p, n - 1, dp) == 1;
    }

    private int isMatchUtil(String s, int m, String p, int n, int[][] dp) {
        if (m < 0 && n < 0) {
            return 1;
        }

        if (m >= 0 && n < 0) {
            return 0;
        }

        if (m < 0) {
            for (int i = 0; i <= n; i++) {
                if (p.charAt(i) != '*') {
                    return 0;
                }
            }

            return 1;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '?') {
            dp[m][n] = isMatchUtil(s, m - 1, p, n - 1, dp);
        } else if (p.charAt(n) == '*') {
            dp[m][n] = isMatchUtil(s, m - 1, p, n, dp) | isMatchUtil(s, m, p, n - 1, dp);
        } else {
            dp[m][n] = 0;
        }

        return dp[m][n];
    }
}
