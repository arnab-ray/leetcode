package dynamicprogramming.medium;

public class CountSquareSubmatrices {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] size = new int[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    size[i][j] = matrix[i][j];
                    count += matrix[i][j];
                } else {
                    if(matrix[i][j] == 0) {
                        size[i][j] = 0;
                    } else {
                        int min = Math.min(size[i - 1][j - 1], Math.min(size[i - 1][j], size[i][j - 1]));
                        size[i][j] = min + 1;
                        count += (min + 1);
                    }
                }
            }
        }

        return count;
    }
}
