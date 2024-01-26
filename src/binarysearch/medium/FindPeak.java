package binarysearch.medium;

public class FindPeak {
    private int findPeakElementUtil(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
            return mid;
        else if (mid > 0 && nums[mid] < nums[mid - 1])
            return findPeakElementUtil(nums, low, mid - 1);
        else
            return findPeakElementUtil(nums, mid + 1, high);
    }

    public int findPeakElement(int[] nums) {
        return findPeakElementUtil(nums, 0, nums.length - 1);
    }
}
