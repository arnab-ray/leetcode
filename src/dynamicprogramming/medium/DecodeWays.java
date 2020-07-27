package dynamicprogramming.medium;

import java.util.Arrays;

public class DecodeWays {

    private int numDecodingUtil(String s, int end, int[] decodeLookup) {
        if(s.charAt(0) == '0')
            return 0;

        if(end == 0 || end == 1)
            return 1;

        if(decodeLookup[end - 1] == -1) {
            int count = 0;
            if(s.charAt(end - 1) > '0')
                count = numDecodingUtil(s, end - 1, decodeLookup);
            if(s.charAt(end - 2) == '1' || (s.charAt(end - 2) == '2' && s.charAt(end - 1) <= '6'))
                count += numDecodingUtil(s, end - 2, decodeLookup);

            decodeLookup[end - 1] = count;
        }
        return decodeLookup[end - 1];
    }

    public int numDecodings(String s) {
        int[] decodeLookup = new int[s.length()];
        Arrays.fill(decodeLookup, -1);
        return numDecodingUtil(s, s.length(), decodeLookup);
    }
}
