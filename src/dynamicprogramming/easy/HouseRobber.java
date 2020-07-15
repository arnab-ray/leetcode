package dynamicprogramming.easy;

public class HouseRobber {
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

        for(int i = 2; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                int val = res[j] + nums[i];
                if(j < i - 1 &&  (res[i] < val))
                    res[i] = val;
            }
        }

        return Math.max(res[nums.length - 1], res[nums.length - 2]);
    }
}
