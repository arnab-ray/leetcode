package string.easy;

import java.util.Arrays;

public class GenerateStringWithOddCounts {
    public String generateTheString(int n) {
        int[] count = new int[26];
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char) (index + 'a'));
            count[index] += 1;
            n--;
            if ((n - count[index]) % 2 == 0) {
                index = (index + 1) % 26;
            }
        }

        return sb.toString();
    }
}
