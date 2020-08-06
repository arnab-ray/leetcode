package arrays.medium;

public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(s == 0 || nums == null || nums.length == 0)
            return 0;

        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;

        while (end < nums.length && start <= end) {
            currentSum += nums[end++];

            while (currentSum - nums[start] >= s) {
                currentSum -= nums[start++];
            }

            if(currentSum >= s) {
                minLength = Math.min(minLength, end - start);
            }
        }


        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
