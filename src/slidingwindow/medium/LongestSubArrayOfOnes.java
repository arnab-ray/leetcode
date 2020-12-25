package slidingwindow.medium;

public class LongestSubArrayOfOnes {
    public int longestSubarray(int[] nums) {
        int start = 0, end = 0, count = 1;

        for (end = 0; end < nums.length; end++) {
            if (nums[end] == 0)
                count--;

            if (count < 0 && nums[start++] == 0)
                count++;
        }

        return end - start - 1;
    }
}
