package greedy.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxScoreRemovingStones {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(a);
        queue.add(b);
        queue.add(c);

        int rounds = 0;
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();

            rounds++;

            x--;
            y--;
            if (x > 0)
                queue.add(x);
            if (y > 0)
                queue.add(y);
        }

        return rounds;
    }
}
