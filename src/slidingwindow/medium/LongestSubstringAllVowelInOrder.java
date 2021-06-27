package slidingwindow.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringAllVowelInOrder {
    public int longestBeautifulSubstring(String word) {
        if (word.length() < 5)
            return 0;

        int maxLen = 0, left = 0;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (i > 0 && word.charAt(i) < word.charAt(i - 1)) {
                maxLen = set.size() == 5 ? Math.max(maxLen, i - left) : maxLen;
                left = i;
                set = new HashSet<>();
            }
            set.add(word.charAt(i));
        }

        maxLen = set.size() == 5 ? Math.max(maxLen, word.length() - left) : maxLen;
        return maxLen;
    }
}
