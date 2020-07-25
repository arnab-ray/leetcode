package arrays.medium;

import java.util.Arrays;

public class NextHigherPermutation {
    private void rotateArray(int[] nums, int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low++] = nums[high];
            nums[high--] = temp;
        }
    }

    public void nextPermutation(int[] nums) {
        int lowerIndex = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]) {
                lowerIndex = i - 1;
                break;
            }
        }

        if(lowerIndex == -1) {
            rotateArray(nums, 0, nums.length - 1);
        } else {
            int higherIndex = lowerIndex + 1;
            for(int i = lowerIndex + 2; i < nums.length; i++) {
                if(nums[i] > nums[lowerIndex] && nums[i] < nums[higherIndex])
                    higherIndex = i;
            }

            int temp = nums[lowerIndex];
            nums[lowerIndex] = nums[higherIndex];
            nums[higherIndex] = temp;

            int low = lowerIndex + 1;
            int high = nums.length;
            Arrays.sort(nums, low, high);
        }
    }
}
