package dynamicprogramming.medium;

import java.util.Arrays;

public class CombinationSum4 {
    private int findAmount(int[] nums, int target, int[] amount) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else if (amount[target] != -1) {
            return amount[target];
        } else {
            int ways = 0;
            for (int num : nums)
                ways += findAmount(nums, target - num, amount);

            amount[target] = ways;
            return amount[target];
        }
    }

    public int combinationSum4(int[] nums, int target) {
        int[] amount = new int[target + 1];
        Arrays.fill(amount, -1);
        return findAmount(nums, target, amount);
    }
}
