package dynamicprogramming.medium;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MinCostTree {
    private int findMaxVal(int[] arr, int start, int end) {
        int max = -1;
        for (int i = start; i <= end; i++)
            max = Math.max(max, arr[i]);

        return max;
    }

    private int count(int[] arr) {
        if(arr == null || arr.length <= 1) return 0;

        int[][] lookup = new int[arr.length][arr.length];

        for(int j = 0; j < arr.length; j++) {
            for(int i = j - 1; i >= 0; i--) {
                for(int k = i; k < j; k++) {
                    int val = lookup[i][k] + lookup[k + 1][j] + findMaxVal(arr, i, k) * findMaxVal(arr, k + 1, j);
                    if(lookup[i][j] == 0) lookup[i][j] = val;
                    lookup[i][j] = Math.min(lookup[i][j], val);
                }
            }
        }

        return lookup[0][arr.length - 1];
    }

    private int count_(int[] arr, int start, int end, AtomicInteger sum) {
        if(start > end || start < 0 || start >= arr.length || end >= arr.length) return 0;

        if(start == end - 1) {
            sum.set(sum.get() + (arr[start] * arr[end]));
            return Math.max(arr[start], arr[end]);
        }

        int maxIndex = start;
        for(int i = start; i <= end; i++) {
            if(arr[i] >= arr[maxIndex])
                maxIndex = i;
        }

        int max_a = count_(arr, start, maxIndex - 1, sum);
        int max_b = count_(arr, maxIndex + 1, end, sum);

        if(max_a > 0) sum.set(sum.get() + (arr[maxIndex] * max_a));
        if(max_b > 0) sum.set(sum.get() + (arr[maxIndex] * max_b));

        return Math.max(arr[maxIndex], Math.max(max_a, max_b));
    }

    public int mctFromLeafValues(int[] arr) {
        AtomicInteger sum = new AtomicInteger(0);
        count_(arr, 0, arr.length - 1, sum);

        return sum.get();
    }
}
