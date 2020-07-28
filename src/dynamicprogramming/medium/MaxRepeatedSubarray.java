package dynamicprogramming.medium;

public class MaxRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int[][] lcs = new int[A.length + 1][B.length + 1];
        int maxLength = Integer.MIN_VALUE;
        for(int i = 1; i <= A.length; i++) {
            for(int j = 1; j <= B.length; j++) {
                if(A[i - 1] == B[j - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                    if(lcs[i][j] > maxLength)
                        maxLength = lcs[i][j];
                }
            }
        }

        return maxLength;
    }
}
