package slidingwindow.medium;

public class SubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int currentVal = 1;
        int count = 0;

        for(int end = 0; end < nums.length; end++) {
            if(nums[end] * currentVal < k) {
                count += (end - start) + 1;
                currentVal = nums[end] * currentVal;
            } else {
                while(nums[end] * currentVal >= k && start <= end) {
                    currentVal = currentVal / nums[start] == 0 ? 1 : currentVal / nums[start];
                    start++;
                }
                if(nums[end] * currentVal < k) {
                    count += (end - start) + 1;
                    currentVal = nums[end] * currentVal;
                }
            }
        }

        return count;
    }
}
