package dynamicprogramming.medium;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = nums[1];

        res[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++)
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);

        res[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length - 1; i++)
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);

        return Math.max(res[nums.length - 1], res[nums.length - 2]);
    }
}
