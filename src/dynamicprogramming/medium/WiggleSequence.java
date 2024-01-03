package dynamicprogramming.medium;

import java.util.Arrays;

public class WiggleSequence {
    private int[] LIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }

        return lis;
    }

    private int[] LDS(int[] nums) {
        int[] lds = new int[nums.length];
        Arrays.fill(lds, 1);

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] > nums[i] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;
            }
        }

        return lds;
    }

    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums.length;

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int[] lds = new int[nums.length];
        Arrays.fill(lds, 1);

        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && lds[j] + 1 > lis[i])
                    lis[i] = lds[j] + 1;
                else if(nums[j] > nums[i] && lis[j] + 1 > lds[i])
                    lds[i] = lis[j] + 1;
            }
        }

        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, Math.max(lis[i], lds[i]));
        }

        return maxLength;
    }
}
