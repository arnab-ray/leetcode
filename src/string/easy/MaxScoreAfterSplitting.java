package string.easy;

public class MaxScoreAfterSplitting {
    public int maxScore(String s) {
        int countOnes = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                countOnes++;
        }

        int maxVal = Integer.MIN_VALUE;
        int countLeft = 0, countRight = countOnes;

        for (int i = 0; i < s.length() - 1; i++) {
            // here i is the split point
            if (s.charAt(i) == '0') {
                countLeft++;
            } else {
                countRight--;
            }

            maxVal = Math.max(countLeft + countRight, maxVal);
        }

        return maxVal;
    }
}
