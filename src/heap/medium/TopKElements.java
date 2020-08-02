package heap.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {
    private class Node implements Comparable<Node> {
        int num;
        int freq;

        Node(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }


        @Override
        public int compareTo(Node o) {
            return o.freq - this.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            queue.add(new Node(entry.getKey(), entry.getValue()));

        int[] result = new int[k];
        int i = 0;
        while (k > 0 && !queue.isEmpty()) {
            result[i++] = queue.poll().num;
            k--;
        }

        return result;
    }
}
