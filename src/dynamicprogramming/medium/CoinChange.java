package dynamicprogramming.medium;

public class CoinChange {
    private int coinChangeUtil(int[] coins, int start, int end, int amount, int[][] lookup) {
        if(amount <= 0)
            return 0;
        if(start == end)
            return amount % coins[start] == 0 ? (amount / coins[start]) : Integer.MAX_VALUE - 1;

        if(lookup[amount][end] == -1) {
            lookup[amount][end] = coinChangeUtil(coins, start, end - 1, amount, lookup);
            if(amount - coins[end] >= 0)
                lookup[amount][end] = Math.min(lookup[amount][end],
                        coinChangeUtil(coins, start, end, amount - coins[end], lookup) + 1);
        }
        return lookup[amount][end];
    }

    public int coinChange(int[] coins, int amount) {
        int[][] lookup = new int[amount + 1][coins.length];
        for(int i = 0; i < amount + 1; i++)
            for(int j = 0; j < coins.length; j++)
                lookup[i][j] = -1;
        int val = coinChangeUtil(coins, 0, coins.length - 1, amount, lookup);
        return val == Integer.MAX_VALUE - 1 ? -1 : val;
    }
}
