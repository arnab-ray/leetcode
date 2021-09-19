package dynamicprogramming.medium;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int maxSoFar = nums[0];

        for(int i = 1; i < nums.length; i++){
            int temp = maxEnding;

            maxEnding = Math.max(nums[i], Math.max(nums[i] * maxEnding, nums[i] * minEnding));
            minEnding = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * minEnding));
            maxSoFar = Math.max(maxSoFar, maxEnding);
        }

        return maxSoFar;
    }
}
