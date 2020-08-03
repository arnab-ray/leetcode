package heap.medium;

import java.util.*;

public class TopKFrequentWords {
    private class Node implements Comparable<Node> {
        String word;
        int freq;

        Node(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(Node o) {
            if(o.freq == this.freq)
                return this.word.compareTo(o.word);
            return o.freq - this.freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();

        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        for(Map.Entry<String, Integer> entry : map.entrySet())
            queue.add(new Node(entry.getKey(), entry.getValue()));

        List<String> result = new LinkedList<>();
        for(int i = 0; i < k && !queue.isEmpty(); i++)
            result.add(queue.poll().word);

        return result;
    }
}
