package greedy.medium;

public class ScoreOnFlippingMatrix {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[0].length; j++) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }

        for (int j = 0; j < A[0].length; j++) {
            int zeroes = 0, ones = 0;
            for (int[] ints : A) {
                if (ints[j] == 0)
                    zeroes++;
                else
                    ones++;
            }
            if (zeroes > ones) {
                for (int i = 0; i < A.length; i++) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }

        int sum = 0;
        for (int[] ints : A) {
            for (int j = 0; j < A[0].length; j++) {
                sum += (int) (ints[j] * Math.pow(2, A[0].length - j - 1));
            }
        }

        return sum;
    }
}
