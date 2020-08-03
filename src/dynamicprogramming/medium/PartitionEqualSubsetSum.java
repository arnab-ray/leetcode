package dynamicprogramming.medium;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    private int isSubsetSum(int[] nums, int n, int sum, int[][] lookup) {
        if(sum > 0 && n == 0 || sum < 0 || n < 0)
            return 0;
        if(sum == 0)
            return 1;

        if(lookup[n][sum] == -1) {
            lookup[n][sum] = isSubsetSum(nums, n - 1, sum, lookup) | isSubsetSum(nums, n - 1, sum - nums[n], lookup);
        }

        return lookup[n][sum];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;

        if(sum % 2 != 0)
            return false;

        int[][] lookup = new int[nums.length][(sum / 2) + 1];
        for(int[] row : lookup)
            Arrays.fill(row, -1);

        int val = isSubsetSum(nums, nums.length - 1, sum / 2, lookup);
        return val == 1;
    }
}
