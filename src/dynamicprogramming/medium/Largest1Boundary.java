package dynamicprogramming.medium;

public class Largest1Boundary {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] left = new int[grid.length][grid[0].length];
        int[][] top = new int[grid.length][grid[0].length];

        for (int i = 0; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                if(grid[i][j] == 1) {
                    left[i][j] = (j > 0) ? left[i][j - 1] + 1 : 1 ;
                    top[i][j] = (i > 0) ? top[i - 1][j] + 1 : 1 ;
                }
            }
        }

        int max = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int val = Math.min(left[i][j], top[i][j]);
                while (val > max) {
                    if(top[i][j - val + 1] >= val && left[i - val + 1][j] >= val) {
                        max = val;
                    }
                    val--;
                }
            }
        }

        return max * max;
    }
}
