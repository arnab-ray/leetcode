package dynamicprogramming.medium;

public class LongestPalindromicSubsequence {
    private int lpsUtil(String s, int start, int end, int[][] lookup) {
        if(start > end)
            return 0;
        if(start == end)
            return 1;
        if(lookup[start][end] == -1) {
            if(s.charAt(start) == s.charAt(end))
                lookup[start][end] = 2 + lpsUtil(s, start + 1, end - 1, lookup);
            else
                lookup[start][end] = Math.max(lpsUtil(s, start + 1, end, lookup), lpsUtil(s, start, end - 1, lookup));
        }

        return lookup[start][end];
    }

    public int longestPalindromeSubseq(String s) {
        if(s == null || s.isEmpty())
            return 0;
        int[][] lookup = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++)
            for(int j = 0; j < s.length(); j++)
                lookup[i][j] = -1;

        return lpsUtil(s, 0, s.length() - 1, lookup);
    }
}
