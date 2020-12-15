package greedy.medium;

import java.util.*;

public class MinDeletionsToMakeFrequenciesUnique {
    public int minDeletions(String s) {
        int[] charFreq = new int[26];
        for (int i = 0; i < s.length(); i++)
            charFreq[s.charAt(i) - 'a']++;

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] > 0) {
                queue.add(charFreq[i]);
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int currentFreq = queue.poll();
            if (queue.peek() != null && currentFreq == queue.peek()) {
                result++;
                if (currentFreq > 1)
                    queue.add(currentFreq - 1);
            }
        }

        return result;
    }
}
