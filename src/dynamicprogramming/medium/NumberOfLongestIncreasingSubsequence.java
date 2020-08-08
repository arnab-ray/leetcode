package dynamicprogramming.medium;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        int[] count = new int[nums.length];

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    if (lis[i] > maxLen)
                        maxLen = lis[i];
                }
            }
        }

        if (maxLen == 1)
            return lis.length;

        count[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (lis[i] == 1) {
                    count[i] = 1;
                } else if (nums[j] < nums[i] && lis[j] + 1 == lis[i]) {
                    count[i] += count[j];
                }
            }
        }

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            //System.out.print(count[i] + " " + lis[i] + ", ");
            if (lis[i] == maxLen) {
                counter += count[i];
            }
        }

        return counter;
    }
}
