package binarysearch.medium;

public class SearchRotatedSorted {
    private int findPivot(int[] nums, int low, int high) {
        if(low > high)
            return -1;
        if(low == high)
            return low;

        int mid = low + (high - low)/2;
        if(mid < high && nums[mid] > nums[mid + 1])
            return mid;
        else if(low < mid && nums[mid - 1] > nums[mid])
            return mid - 1;
        else if(nums[low] <= nums[mid])
            return findPivot(nums, mid + 1, high);
        else
            return findPivot(nums, low, mid - 1);
    }

    private int searchUtil(int[] nums, int low, int high, int target) {
        if(low > high)
            return -1;

        int mid = low + (high - low)/2;
        if(nums[mid] == target)
            return mid;
        if(target < nums[mid])
            return searchUtil(nums, low, mid - 1, target);
        else
            return searchUtil(nums, mid + 1, high, target);
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int pivot = findPivot(nums, low, high);
        System.out.println(pivot);
        if(pivot == -1)
            return searchUtil(nums, low, high, target);

        if(nums[pivot] == target)
            return pivot;
        else if(nums[low] <= target && target < nums[pivot])
            return searchUtil(nums, low, pivot - 1, target);
        else
            return searchUtil(nums, pivot + 1, high, target);
    }
}
