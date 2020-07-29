package dynamicprogramming.medium;

public class LongestCommonSubsequence {
    private int lcsUtil(String a, int m, String b, int n, int[][] lookup) {
        if(m < 0 || n < 0)
            return 0;

        if(lookup[m][n] == -1) {
            if(a.charAt(m) == b.charAt(n))
                lookup[m][n] = 1 + lcsUtil(a, m - 1, b, n - 1, lookup);
            else
                lookup[m][n] = Math.max(lcsUtil(a, m - 1, b, n, lookup), lcsUtil(a, m, b, n - 1, lookup));
        }

        return lookup[m][n];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] lookup = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++)
            for(int j = 0; j < text2.length(); j++)
                lookup[i][j] = -1;

        return lcsUtil(text1, text1.length() - 1, text2, text2.length() - 1, lookup);
    }
}
