import java.util.Arrays;

public class MaxValForCollectingMoneyEachDay {

    private static int maxValUtilForB(int[] a, int[] b, int c, int n, int[] costA, int[] costB) {
        if (n == 0)
            return b[n];
        else {
            if (costA[n - 1] == -1) {
                int maxA = maxValUtilForA(a, b, c, n - 1, costA, costB);
                costA[n - 1] = maxA;
            }

            if (costB[n - 1] == -1) {
                int maxB = maxValUtilForB(a, b, c, n - 1, costA, costB);
                costB[n - 1] = maxB;
            }

            return Math.max(costB[n - 1] + b[n], costA[n - 1] - c + b[n]);
        }
    }

    private static int maxValUtilForA(int[] a, int[] b, int c, int n, int[] costA, int[] costB) {
        if (n == 0)
            return a[n];
        else {
            if (costA[n - 1] == -1) {
                int maxA = maxValUtilForA(a, b, c, n - 1, costA, costB);
                costA[n - 1] = maxA;
            }

            if (costB[n - 1] == -1) {
                int maxB = maxValUtilForB(a, b, c, n - 1, costA, costB);
                costB[n - 1] = maxB;
            }

            return Math.max(costA[n - 1] + a[n], costB[n - 1] - c + a[n]);
        }
    }

    public static int maxVal(int[] a, int[] b, int c, int n) {
        int[] costA = new int[n];
        int[] costB = new int[n];
        Arrays.fill(costA, -1);
        Arrays.fill(costB, -1);
        return Math.max(maxValUtilForA(a, b, c, n, costA, costB), maxValUtilForB(a, b, c, n, costA, costB));
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 7, 9, 5, 6, 0, 0, 6, 8, 9, 7, 6, 5, 4, 9, 2, 1, 4, 5, 6, 2, 7, 8, 1, 2, 8, 9, 2, 4};
        int[] b = { 1, 2, 5, 4, 2, 7, 9, 5, 6, 0, 0, 6, 8, 9, 7, 6, 5, 4, 9, 2, 1, 4, 5, 6, 2, 7, 8, 1, 2, 8, 9, 2, 4};

        System.out.println(maxVal(a, b, 1, a.length - 1));
    }
}
