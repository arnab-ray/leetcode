package dynamicprogramming.medium;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] numWays = new int[amount + 1];
        numWays[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (coin <= amount && i - coin >= 0) {
                    numWays[i] += numWays[i - coin];
                }
            }
        }

        return numWays[amount];
    }
}
