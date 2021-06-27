package slidingwindow.medium;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int[] count = new int[10001];

        for (int i = 0; i < nums.length; i++) {
            while (count[nums[i]] == 1) {
                sum -= nums[left];
                count[nums[left]]--;
                left++;
            }

            count[nums[i]]++;
            sum += nums[i];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
