package heap.easy;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author arnab.ray
 * @created on 17/01/22
 */
// #1046
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            queue.offer(queue.poll() - queue.poll());
        }

        return queue.peek() != null ? queue.poll() : 0;
    }
}
