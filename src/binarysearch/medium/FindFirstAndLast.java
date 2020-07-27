package binarysearch.medium;

public class FindFirstAndLast {
    private int getFirstPos(int[] nums, int low, int high, int target) {
        if(low > high)
            return -1;
        if(low == high)
            return nums[low] == target ? low : -1;

        int mid = low + (high - low)/2;
        if(nums[mid] == target && (low == mid || (low < mid && nums[mid - 1] < nums[mid])))
            return mid;
        else if(nums[mid] == target)
            return getFirstPos(nums, low, mid - 1, target);
        else if (nums[mid] > target)
            return getFirstPos(nums, low, mid - 1, target);
        else
            return getFirstPos(nums, mid + 1, high, target);
    }

    private int getLastPos(int[] nums, int low, int high, int target) {
        if(low > high)
            return -1;
        if(low == high)
            return nums[low] == target ? low : -1;

        int mid = low + (high - low)/2;
        if(nums[mid] == target && (mid == high || (mid < high && nums[mid] < nums[mid + 1])))
            return mid;
        else if(nums[mid] == target)
            return getLastPos(nums, mid + 1, high, target);
        else if (nums[mid] > target)
            return getLastPos(nums, low, mid - 1, target);
        else
            return getLastPos(nums, mid + 1, high, target);
    }

    public int[] searchRange(int[] nums, int target) {
        int firstPos = getFirstPos(nums, 0, nums.length - 1, target);
        int lastPos = getLastPos(nums, 0, nums.length - 1, target);

        return new int[]{firstPos, lastPos};
    }
}
