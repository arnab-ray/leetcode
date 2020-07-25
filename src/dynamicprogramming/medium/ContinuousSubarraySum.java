package dynamicprogramming.medium;

public class ContinuousSubarraySum {
    private boolean areAllZero(int[] nums) {
        for(int num: nums) {
            if(num > 0)
                return false;
        }
        return true;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2)
            return false;

        if(areAllZero(nums))
            return true;

        for(int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for(int j = i + 1; j < nums.length; j ++) {
                sum += nums[j];
                System.out.println("Sum: " + sum);
                if(k == 0 && sum == 0)
                    return true;
                else if(k != 0 && sum % k == 0)
                    return true;
            }
        }

        return false;
    }
}
