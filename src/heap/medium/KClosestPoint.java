package heap.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoint {

    private static final Comparator<Integer[]> comparator = new Comparator<Integer[]>() {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return (o1[0]*o1[0] + o1[1]*o1[1]) - (o2[0]*o2[0] + o2[1]*o2[1]);
        }
    };

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(K, comparator);
        for(int[] point : points) {
            Integer[] point_ = new Integer[2];
            point_[0] = point[0];
            point_[1] = point[1];

            queue.add(point_);
        }

        int[][] result = new int[K][2];
        int i = 0;
        while (!queue.isEmpty() && i < K) {
            Integer[] point = queue.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
            i++;
        }

        return result;
    }
}
