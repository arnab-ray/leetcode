package heap.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 || k == 0)
            return -1;

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int num : nums)
            queue.add(num);

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int val = queue.poll();
            if(count == k)
                return val;
        }

        return -1;
    }
}
