package arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> unvisited = new HashSet<>();
        for (int num : nums) {
            unvisited.add(num);
        }

        int maxLength = 0;
        for (int num : nums) {
            if (unvisited.contains(num)) {
                unvisited.remove(num);
                int currentLength = 1;
                int prevVal = num - 1;
                int nextVal = num + 1;
                while (unvisited.contains(prevVal)) {
                    unvisited.remove(prevVal);
                    currentLength++;
                    prevVal--;
                }
                while (unvisited.contains(nextVal)) {
                    unvisited.remove(nextVal);
                    currentLength++;
                    nextVal++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
