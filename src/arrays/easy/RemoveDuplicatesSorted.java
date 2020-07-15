package arrays.easy;

public class RemoveDuplicatesSorted {
    public int removeDuplicates(int[] nums) {
        int last_index = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[last_index++] = nums[i];
            }
        }

        return last_index;
    }

    public static void main(String[] args) {

    }
}
