package binarysearch.medium;

public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length > 0) {
            int startRow = 0;
            int startColumn = matrix[0].length - 1;

            while (startRow < matrix.length && startColumn >= 0) {
                if(matrix[startRow][startColumn] == target)
                    return true;
                else if(startColumn - 1 >= 0 && matrix[startRow][startColumn - 1] >= target)
                    startColumn--;
                else
                    startRow++;
            }

            return false;
        }

        return false;
    }
}
