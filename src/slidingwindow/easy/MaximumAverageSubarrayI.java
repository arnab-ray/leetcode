package slidingwindow.easy;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max = (double) sum / k;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, (double) sum / k);
        }

        return max;
    }
}
