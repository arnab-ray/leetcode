package arrays.medium;

import java.util.Arrays;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int[] arr = new int[A.length * 2];
        for(int i = 0; i < A.length; i++)
            arr[i] = A[i];
        for(int i = A.length; i < A.length * 2; i++)
            arr[i] = A[i - A.length];

        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int j : arr) {
            currMax = Math.max(j, currMax + j);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }
}
