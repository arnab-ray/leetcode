package greedy.medium;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SellDiminishingColouredBalls {
    public int maxProfit(int[] inventory, int orders) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int j : inventory) queue.add(j);

        int count = 0, total = 0, mod = 1000000007;
        while (!queue.isEmpty() && count < orders) {
            Integer n = queue.poll();
            total = (total + n) % mod;
            if (n - 1 > 0)
                queue.add(n - 1);
            count++;
        }

        return total;
    }
}
