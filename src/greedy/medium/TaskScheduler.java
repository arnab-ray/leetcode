package greedy.medium;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if(n == 0)
            return tasks.length;

        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : tasks) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(freqMap.values());

        int maxFrequency = queue.isEmpty() ? 0 : queue.poll();
        int totalIdleTime = (maxFrequency - 1) * n;

        while (!queue.isEmpty()) {
            int currentFreq = queue.poll();
            if(currentFreq == maxFrequency)
                totalIdleTime = totalIdleTime - currentFreq + 1;
            else
                totalIdleTime -= currentFreq;
        }

        if(totalIdleTime > 0)
            return totalIdleTime + tasks.length;
        else
            return tasks.length;
    }
}
