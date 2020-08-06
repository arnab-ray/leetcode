package dynamicprogramming.medium;

public class LongestPalindromicSubstring {
    private int[] longestPalindromeUtil(String s) {
        int n = s.length();
        boolean[][] lookup = new boolean[n][n];
        int maxLength = 1;
        int[] indices = new int[2];
        int start = 0;

        for(int i = 0; i < n; i++) {
            lookup[i][i] = true;
            start = i;
        }

        for(int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                lookup[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }

        // iterate over strings of length 3 or more
        for(int len = 3; len <= n; len++) {
            for(int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && lookup[i + 1][j - 1]) {
                    lookup[i][j] = true;
                    if(j - i + 1 > maxLength) {
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }

        indices[0] = start; indices[1] = start + maxLength - 1;

        return indices;
    }

    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty())
            return s;
        int[] indices = longestPalindromeUtil(s);
        return s.substring(indices[0], indices[1] + 1);
    }
}
