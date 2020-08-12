package bitmanipulation.medium;

public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums)
            xor ^= num;

        xor &= -xor;
        System.out.println(xor);

        int[] result = new int[2];
        for(int num : nums) {
            if((num & xor) == 0)
                result[0] ^= num;
            else
                result[1] ^= num;
        }

        return result;
    }
}
