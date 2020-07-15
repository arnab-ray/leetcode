package arrays.easy;

public class SearchInsertPosition {
    private int searchInsertUtil(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                return searchInsertUtil(nums, target, low, mid - 1);
            else if(nums[mid] < target)
                return searchInsertUtil(nums, target, mid+1, high);
        }

        return low;
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        return searchInsertUtil(nums, target, low, high);
    }
}
