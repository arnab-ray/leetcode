package arrays.medium;

public class IncreasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (min > nums[i])
                min = nums[i];

            if(max < nums[n - i - 1])
                max = nums[n - i - 1];

            left[i] = min;
            right[n - i - 1] = max;
        }

        for (int i = 0; i < n; i++) {
            if(left[i] < nums[i] && nums[i] < right[i]) {
                return true;
            }
        }

        return false;
    }
}
