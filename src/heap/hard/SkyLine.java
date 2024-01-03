package heap.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SkyLine {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> walls = new ArrayList<>();

        for (int[] building : buildings) {
            walls.add(new int[] {building[0], -building[2]});
            walls.add(new int[] {building[1], building[2]});
        }

        walls.sort((w1, w2) -> w1[0] == w2[0] ? w1[1] - w2[1] : w1[0] - w2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int max = 0;

        for (int[] wall : walls) {
            if (wall[1] < 0) {
                pq.offer(-wall[1]);
            } else {
                pq.remove(wall[1]);
            }

            if (!pq.isEmpty()) {
                int currMax = pq.peek();
                if (currMax != max) {
                    List<Integer> subRes = new ArrayList<>();
                    subRes.add(wall[0]);
                    subRes.add(currMax);
                    res.add(subRes);
                    max = currMax;
                }
            }
        }

        return res;
    }

}
