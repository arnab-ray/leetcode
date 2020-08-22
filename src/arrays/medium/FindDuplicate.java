package arrays.medium;

import java.util.Arrays;

public class FindDuplicate {
    private int getNum(int[] nums, int low, int high) {
        if(low > high)
            return -1;

        int mid = low + (high - low) / 2;
        if(mid > 0 && nums[mid] == nums[mid - 1])
            return mid;
        else if(nums[mid] > mid)
            return getNum(nums, mid + 1, high);
        else
            return getNum(nums, low, mid - 1);
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int index = getNum(nums, 0, nums.length);

        return nums[index];
    }
}
