package bitmanipulation.medium;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        int not_threes;

        for (int num : nums) {
            /*"one & arr[i]" gives the bits that are there in
            both 'ones' and new element from arr[]. We
            add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & num);
            ones = ones ^ num;

            /* The common bits are those bits which appear third time
            So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can
            be removed from 'ones' and 'twos'*/
            not_threes = ~(ones & twos);

            /*Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= not_threes;

            /*Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= not_threes;
        }
        return ones;
    }
}
