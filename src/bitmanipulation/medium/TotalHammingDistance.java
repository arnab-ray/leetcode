package bitmanipulation.medium;

public class TotalHammingDistance {
    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }

        return count;
    }

    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                count += countSetBits(nums[i] ^ nums[j]);

        return count;
    }
}
