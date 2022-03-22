package dynamicprogramming.hard;

// #72
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        int[][] d = new int[m+1][n+1];

        for(int i = 0; i < m+1; i++)
        {
            for(int j = 0; j < n+1; j++)
            {
                if(i == 0)
                    d[i][j] = j;
                else if(j == 0)
                    d[i][j] = i;
                else if(str1[i-1] == str2[j-1])
                    d[i][j] = d[i-1][j-1];
                else
                    d[i][j] = 1 + Math.min(d[i-1][j], Math.min(d[i][j-1], d[i-1][j-1]));
            }
        }

        return d[m][n];
    }
}
