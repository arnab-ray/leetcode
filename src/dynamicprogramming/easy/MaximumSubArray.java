package dynamicprogramming.easy;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int maxSoFar = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }

        return maxSoFar;
    }
}
