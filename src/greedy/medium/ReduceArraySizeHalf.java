package greedy.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeHalf {
    static class Element {
        int val, frequency;

        public Element(int val, int frequency) {
            this.val = val;
            this.frequency = frequency;
        }
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Element> queue = new PriorityQueue<>(
                (o1, o2) -> o1.frequency == o2.frequency ? o1.val - o2.val : o2.frequency - o1.frequency);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Element(entry.getKey(), entry.getValue()));
        }

        int count = 0;
        int currentSize = arr.length;
        while (!queue.isEmpty()) {
            Element element = queue.poll();
            count++;
            currentSize -= element.frequency;

            if (currentSize <= arr.length / 2)
                break;
        }

        return count;
    }
}
