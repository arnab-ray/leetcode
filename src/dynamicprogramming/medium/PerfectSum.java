package dynamicprogramming.medium;

import java.util.Arrays;

public class PerfectSum {
    public int numSquares(int n) {
        int[] numWays = new int[n + 1];
        Arrays.fill(numWays, Integer.MAX_VALUE);

        numWays[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int ways = i / (j * j);
                int rem = i % (j * j);

                numWays[i] = rem == 0 ? Math.min(numWays[i], ways) : Math.min(numWays[i], numWays[i - ways * (j * j)] + ways);
            }
        }

        return numWays[n];
    }
}
