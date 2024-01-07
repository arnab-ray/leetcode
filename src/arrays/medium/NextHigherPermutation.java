package arrays.medium;

import java.util.Arrays;

// #31
public class NextHigherPermutation {
    private static void rotateArray(int[] nums, int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low++] = nums[high];
            nums[high--] = temp;
        }
    }

    public static void nextPermutation(int[] nums) {
        int lowerIndex = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]) {
                lowerIndex = i - 1;
                break;
            }
        }

        System.out.println(lowerIndex);
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

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 6, 5, 7, 8};
        nextPermutation(nums);
        for (int i : nums)
            System.out.print(i + " ");
        System.out.println();
    }
}
