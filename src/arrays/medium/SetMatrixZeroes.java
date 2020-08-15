package arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(!(rows.contains(i) && cols.contains(j))) {
                        rows.add(i); cols.add(j);
                    }
                }
            }
        }

        for(Integer i : rows) {
            for(int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = 0;
        }

        for(Integer j : cols) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void setZeroes_(int[][] matrix) {
        boolean firstRow = false;
        boolean firstColumn = false;

        for(int[] ints : matrix) {
            if (ints[0] == 0) {
                firstColumn = true;
                break;
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if(firstRow) {
            Arrays.fill(matrix[0], 0);
        }

        if(firstColumn) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
