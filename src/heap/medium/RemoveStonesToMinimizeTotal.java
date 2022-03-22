package heap.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author arnab.ray
 * @created on 17/01/22
 */
// #1962
public class RemoveStonesToMinimizeTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : piles)
            queue.offer(i);

        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                Integer a = queue.poll();
                Integer val = a % 2 == 0 ? a / 2 : a / 2 + 1;
                queue.offer(val);
            } else {
                break;
            }
        }

        int count = 0;
        while (!queue.isEmpty())
            count += queue.poll();

        return count;
    }
}
