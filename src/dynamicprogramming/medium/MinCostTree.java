package dynamicprogramming.medium;

import java.util.Arrays;

public class MinCostTree {
    private int findMaxVal(int[] arr, int start, int end, int[][] lookup) {
        if(lookup[start][end] == -1) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            lookup[start][end] = max == Integer.MIN_VALUE ? -1 : max;
        }

        return lookup[start][end];
    }

    private int count(int[] arr, int start, int end, int[] val, int[][] lookup) {
        if(end < 0 || start == end)
            return 0;
        else {
            if(val[end - 1] == -1) {
                val[end - 1] = Math.min(findMaxVal(arr, start, end - 1, lookup) * arr[end] + count(arr, start, end - 1, val, lookup),
                        arr[start] * findMaxVal(arr, start + 1, end, lookup) + count(arr, start + 1, end, val, lookup));
            }

            return val[end - 1];
        }
    }

    public int mctFromLeafValues(int[] arr) {
        int[] val = new int[arr.length - 1];
        Arrays.fill(val, -1);

        int[][] lookup = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr.length; j++)
                lookup[i][j] = -1;

        int result = count(arr, 0, arr.length - 1, val, lookup);
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                System.out.print(lookup[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < arr.length - 1; i++)
            System.out.print(val[i] + " ");

        return result;
    }
}
