package slidingwindow.medium;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingChar {
    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) {
            return 0;
        }
        int[] count = new int[26];
        int maxLen = 0;
        for (int left = 0; left < s.length(); left++) {
            Arrays.fill(count, 0);
            for (int right = left; right < s.length(); right++) {
                count[s.charAt(right) - 'a']++;
                if (isValid(count, s, left, right, k)) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
        }

        return maxLen;
    }

    private boolean isValid(int[] count, String s, int left, int right, int k) {
        for (int i = left; i <= right; i++) {
            if (count[s.charAt(i) - 'a'] < k)
                return false;
        }

        return true;
    }
}
