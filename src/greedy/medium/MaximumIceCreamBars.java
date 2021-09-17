package greedy.medium;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;

        for (int i = 0; i < costs.length; i++) {
            if (costs[i] > coins) {
                break;
            }

            count++;
            coins -= costs[i];
        }

        return count;
    }
}
