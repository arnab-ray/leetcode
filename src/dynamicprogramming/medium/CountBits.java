package dynamicprogramming.medium;

public class CountBits {
    public int[] countBits(int num) {
        int[] bitCount = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            if(i == 0 || i == 1) {
                bitCount[i] = i;
            } else {
                int quotient = i / 2;
                int remainder = i % 2;
                bitCount[i] = bitCount[quotient] + remainder;
            }
        }

        return bitCount;
    }
}
