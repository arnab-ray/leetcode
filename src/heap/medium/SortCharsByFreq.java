package heap.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author arnab.ray
 * @created on 17/01/22
 */
// #451
public class SortCharsByFreq {
    static class CharFreq {
        char c;
        int f;

        public CharFreq(char c, int f) {
            this.c = c;
            this.f = f;
        }
    }

    private final Comparator<CharFreq> comparator = new Comparator<CharFreq>() {
        @Override
        public int compare(CharFreq o1, CharFreq o2) {
            return o2.f - o1.f;
        }
    };

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        PriorityQueue<CharFreq> queue = new PriorityQueue<>(comparator);
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            queue.offer(new CharFreq(entry.getKey(), entry.getValue()));

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            CharFreq charFreq = queue.poll();
            for (int i = 0; i < charFreq.f; i++)
                sb.append(charFreq.c);
        }

        return sb.toString();
    }
}
