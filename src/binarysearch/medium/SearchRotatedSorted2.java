package binarysearch.medium;

public class SearchRotatedSorted2 {
    private boolean searchUtil(int[] nums, int low, int high, int target) {
        if(low > high)
            return false;

        int mid = low + (high - low)/2;
        if(nums[low] == target || nums[mid] == target || nums[high] == target) {
            return true;
        }
        if(nums[low] >= nums[mid] && (nums[low] < target || target < nums[mid])) {
            return searchUtil(nums, low + 1, mid - 1, target) || searchUtil(nums, mid + 1, high - 1, target);
        } else {
            if(nums[low] < target && target < nums[mid])
                return searchUtil(nums, low + 1, mid - 1, target);
            else
                return searchUtil(nums, mid + 1, high - 1, target);
        }
    }

    public boolean search(int[] nums, int target) {
        if(nums == null)
            return false;

        return searchUtil(nums, 0, nums.length - 1, target);
    }
}
