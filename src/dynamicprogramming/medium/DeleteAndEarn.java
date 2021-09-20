package dynamicprogramming.medium;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int[] sum = new int[10001];
        int maxVal = Integer.MIN_VALUE;

        for(int i : nums){
            sum[i] += i;
            maxVal = Math.max(maxVal, i);
        }

        for(int i = 2; i <= maxVal; i++){
            sum[i] = Math.max(sum[i - 2] + sum[i], sum[i - 1]);
        }

        return sum[maxVal];
    }
}
