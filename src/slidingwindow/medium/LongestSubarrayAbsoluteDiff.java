package slidingwindow.medium;

import java.util.TreeMap;

public class LongestSubarrayAbsoluteDiff {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (Math.abs(map.firstKey() - map.lastKey()) > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
