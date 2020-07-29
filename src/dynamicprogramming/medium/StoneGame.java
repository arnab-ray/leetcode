package dynamicprogramming.medium;

import java.util.Arrays;

public class StoneGame {
    private int alexSum(int[] piles, int start, int end, int turn, int[][] lookup) {
        if(turn == 0)
            return 0;
        if(start == end)
            return piles[start];

        if(lookup[start][end] == -1) {
            lookup[start][end] = Math.max(alexSum(piles, start + 1, end, turn - 1, lookup) + piles[start],
                    alexSum(piles, start, end - 1, turn - 1, lookup) + piles[end]);
        }

        return lookup[start][end];
    }

    public boolean stoneGame(int[] piles) {
        int sum = Arrays.stream(piles).reduce(0, Integer::sum);
        int turnLength = piles.length / 2;
        int[][] lookup = new int[piles.length][piles.length];
        for(int i = 0; i < piles.length; i++)
            for(int j = 0; j < piles.length; j++)
                lookup[i][j] = -1;

        int alexScore = alexSum(piles, 0, piles.length - 1, turnLength, lookup);

        return alexScore >= sum / 2;
    }
}
