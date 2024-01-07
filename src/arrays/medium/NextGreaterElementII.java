package arrays.medium;

public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        boolean flag;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            flag = false;
            int limit = (nums.length - i) + 2 * i;
            for (int j = i + 1; j <= limit; j++) {
                if (nums[i] < nums[j % nums.length]) {
                    flag = true;
                    result[i] = nums[j % nums.length];
                    break;
                }
            }

            if (!flag)
                result[i] = -1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,4,3,2,1};
        int[] result = nextGreaterElements(nums);

        for (int i : result)
            System.out.print(i + " ");
        System.out.println();
    }
}
