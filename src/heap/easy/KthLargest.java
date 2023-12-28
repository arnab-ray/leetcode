package heap.easy;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> queue;
    int size;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.size = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(queue.size() < size) {
            queue.add(val);
        } else if(!queue.isEmpty() && val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }

        return queue.peek();
    }
}
