package binarysearch.medium;

import java.util.PriorityQueue;

public class KthSmallestInArray {
    public int kthSmallest(int[][] matrix, int k) {
        int val = -1;
        if(matrix.length > 0) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(k);

            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    if (queue.size() == k && anInt < queue.peek())
                        queue.poll();
                    queue.add(anInt);
                }
            }

            for(int i = 0; i < k; i++)
                if(!queue.isEmpty())
                    val = queue.poll();
        }

        return val;
    }
}
