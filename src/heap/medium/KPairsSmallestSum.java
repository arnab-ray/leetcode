package heap.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author arnab.ray
 * @created on 17/01/22
 */
// #373
public class KPairsSmallestSum {
    static class NumSum {
        int i, j, sum;

        public NumSum(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    private final Comparator<NumSum> comparator = new Comparator<NumSum>() {
        @Override
        public int compare(NumSum o1, NumSum o2) {
            return o1.sum - o2.sum;
        }
    };

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<NumSum> queue = new PriorityQueue<>(comparator);

        int max_i = Math.min(k, nums1.length);
        int max_j = Math.min(k, nums2.length);
        for (int i = 0; i < max_i; i++) {
            for (int j = 0; j < max_j; j++) {
                queue.offer(new NumSum(nums1[i], nums2[j], nums1[i] + nums2[j]));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                NumSum temp = queue.poll();
                List<Integer> tempList = new ArrayList<>();
                tempList.add(temp.i);
                tempList.add(temp.j);
                result.add(tempList);
            }
        }

        return result;
    }
}
