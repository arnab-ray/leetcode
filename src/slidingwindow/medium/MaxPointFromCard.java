package slidingwindow.medium;

public class MaxPointFromCard {
    public int maxScore(int[] cardPoints, int k) {
        int[] leftSum = new int[k + 1];
        int[] rightSum = new int[k + 1];
        leftSum[0] = 0;
        rightSum[0] = 0;

        for (int i = 1; i <= k; i++)
            leftSum[i] = leftSum[i - 1] + cardPoints[i - 1];

        for (int i = 1; i <= k; i++)
            rightSum[i] = rightSum[i - 1] + cardPoints[cardPoints.length - i];

        int maxPoint = 0;
        for (int i = 0; i <= k; i++)
            maxPoint = Math.max(maxPoint, leftSum[i] + rightSum[k - i]);

        return maxPoint;
    }
}
