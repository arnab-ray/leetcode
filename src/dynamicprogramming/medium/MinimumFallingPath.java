package dynamicprogramming.medium;

public class MinimumFallingPath {
    public int minFallingPathSum(int[][] A) {
        int minValue = Integer.MAX_VALUE;
        int[][] pathVal = new int[A.length][A[0].length];

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(i == 0)
                    pathVal[i][j] = A[i][j];
                else if(j == 0)
                    pathVal[i][j] = Math.min(A[i][j] + pathVal[i - 1][j], A[i][j] + pathVal[i - 1][j + 1]);
                else if(j == A[0].length - 1)
                    pathVal[i][j] = Math.min(A[i][j] + pathVal[i - 1][j], A[i][j] + pathVal[i - 1][j - 1]);
                else
                    pathVal[i][j] = Math.min(Math.min(A[i][j] + pathVal[i - 1][j], A[i][j] + pathVal[i - 1][j + 1]),
                            A[i][j] + pathVal[i - 1][j - 1]);
            }
        }

        for(int j = 0; j < A[0].length; j++)
            if(pathVal[A.length - 1][j] < minValue)
                minValue = pathVal[A.length - 1][j];

        return minValue;
    }
}
