package arrays.medium;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++)
            result[i] = result[i - 1] * nums[i - 1];

        int mul = 1;
        for(int j = nums.length - 2; j >= 0; j--) {
            mul *= nums[j + 1];
            result[j] = result[j] * mul;
        }

        return result;
    }
}
