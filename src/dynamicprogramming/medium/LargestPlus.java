package dynamicprogramming.medium;

import java.util.Arrays;

public class LargestPlus {
    private int maxLength(int a, int b, int c, int d) {
        return Math.min(Math.min(a, b), Math.min(c, d));
    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dummy = new int[N][N];
        for(int[] row : dummy)
            Arrays.fill(row, 1);
        for(int[] row : mines)
            dummy[row[0]][row[1]] = 0;

        int[][] top = new int[N][N];
        int[][] bottom = new int[N][N];
        int[][] left = new int[N][N];
        int[][] right = new int[N][N];

        //left & right
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(dummy[i][j] == 1)
                    left[i][j] = 1;
                if(dummy[i][j] == 1 && j - 1 >= 0)
                    left[i][j] = left[i][j - 1] + 1;

                if(dummy[N - i - 1][N - j - 1] == 1)
                    right[N - i - 1][N - j - 1] = 1;
                if(dummy[N - i - 1][N - j - 1] == 1 && N - j < N)
                    right[N - i - 1][N - j - 1] = right[N - i - 1][N - j] + 1;
            }
        }

        //top & bottom
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(dummy[i][j] == 1)
                    top[i][j] = 1;
                if(dummy[i][j] == 1 && i - 1 >= 0)
                    top[i][j] = top[i - 1][j] + 1;

                if(dummy[N - i - 1][N - j - 1] == 1)
                    bottom[N - i - 1][N - j - 1] = 1;
                if(dummy[N - i - 1][N - j - 1] == 1 && N - i < N)
                    bottom[N - i - 1][N - j - 1] = bottom[N - i][N - j - 1] + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int maxLen = maxLength(left[i][j], right[i][j], top[i][j], bottom[i][j]);
                if(maxLen > max)
                    max = maxLen;
            }
        }

        return max;
    }
}
