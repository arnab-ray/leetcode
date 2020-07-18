package binarysearch.medium;

public class MinimumInRotatedSortedArray {
    private int findMinUtil(int[] nums, int low, int high) {
        if(high < low) return nums[0];
        if(high == low) return nums[low];

        int mid = low + (high - low)/2;
        if(mid < high && nums[mid + 1] < nums[mid])
            return nums[mid + 1];
        if(mid > low && nums[mid - 1] > nums[mid])
            return nums[mid];

        if(nums[high] > nums[mid])
            return findMinUtil(nums, low, mid - 1);
        else
            return findMinUtil(nums, mid + 1, high);


    }
    public int findMin(int[] nums) {
        return findMinUtil(nums, 0, nums.length - 1);
    }
}
