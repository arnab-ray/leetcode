package binarysearch.medium;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        if(nums.length == 0)
            return -1;

        int x = nums[0];
        for (int i = 1; i < nums.length; i++)
            x = x^nums[i];

        return x;
    }
}
