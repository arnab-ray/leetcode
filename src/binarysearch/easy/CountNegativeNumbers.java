package binarysearch.easy;

public class CountNegativeNumbers {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0, i = 0, j = n - 1;

        while (i < m && j >= 0) {
            if (grid[i][j] < 0) {
                count += (m - i);
                j--;
            } else {
                i++;
            }
        }

        return count;
    }
}
