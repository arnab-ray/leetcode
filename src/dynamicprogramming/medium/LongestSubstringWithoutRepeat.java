package dynamicprogramming.medium;

import java.util.Arrays;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;

        int[] len = new int[s.length()];
        int start = 0;
        boolean[] seen = new boolean[128];
        len[0] = 1; seen[s.charAt(0)] = true;

        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(seen[c]) {
                while (s.charAt(start) != c) {
                    seen[s.charAt(start)] = false;
                    start++;
                }
                start++;
            }
            seen[c] = true;
            len[i] = i - start + 1;
        }

        int max = Integer.MIN_VALUE;
        for(int length : len) {
            System.out.print(length + " ");
            if (length > max)
                max = length;
        }
        System.out.println();
        return max;
    }
}
