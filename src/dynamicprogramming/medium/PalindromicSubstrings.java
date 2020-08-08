package dynamicprogramming.medium;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] lookup = new boolean[n][n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            lookup[i][i] = true;
            count++;
        }

        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                lookup[i][i + 1] = true;
                count++;
            }
        }

        for(int len = 3; len <= n; len++) {
            for(int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && lookup[i + 1][j - 1]) {
                    lookup[i][j] = lookup[i + 1][j - 1];
                    if(lookup[i][j]) count++;
                }
            }
        }

        return count;
    }
}
