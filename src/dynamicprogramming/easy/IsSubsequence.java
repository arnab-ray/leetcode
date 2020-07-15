package dynamicprogramming.easy;

public class IsSubsequence {
    public boolean isSubsequence_(String s, String t) {
        int sTracker = 0, tTracker = 0;
        while (sTracker < s.length() && tTracker < t.length()) {
            if(s.charAt(sTracker) == t.charAt(tTracker))
                sTracker++;
            tTracker++;
        }

        return sTracker == s.length();
    }

    private int longestCommonSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] lcs = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if(s.charAt(i - 1) == t.charAt(j - 1))
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
            }
        }

        return lcs[m][n];
    }

    public boolean isSubsequence(String s, String t) {
        int lcsLength = longestCommonSubsequence(s, t);
        return lcsLength == s.length();
    }
}
