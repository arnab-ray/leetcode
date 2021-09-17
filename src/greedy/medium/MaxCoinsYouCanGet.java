package greedy.medium;

import java.util.Arrays;

public class MaxCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count = 0;

        int low = 0, high = piles.length - 2;
        while (low < high) {
            count += piles[high];
            low++;
            high -= 2;
        }

        return count;
    }
}
