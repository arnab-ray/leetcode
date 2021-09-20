package dynamicprogramming.medium;

public class BestSightSeeing {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = Integer.MIN_VALUE;

        int[] maxI = new int[values.length];
        for(int i = 0; i < values.length; i++) {
            maxScore = Math.max(maxScore, values[i] + i);
            maxI[i] = maxScore;
        }

        maxScore = Integer.MIN_VALUE;
        for(int j = 1; j < values.length; j++) {
            maxScore = Math.max(maxScore, maxI[j - 1] + values[j] - j);
        }

        return maxScore;
    }
}
