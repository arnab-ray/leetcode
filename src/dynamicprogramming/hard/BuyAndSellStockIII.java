package dynamicprogramming.hard;

public class BuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int[] leftProfit = new int[prices.length];
        int[] rightProfit = new int[prices.length];

        leftProfit[0] = 0;
        int minVal = prices[0];

        rightProfit[prices.length - 1] = 0;
        int maxVal = prices[prices.length - 1];

        for (int i = 1; i < prices.length; i++) {
            minVal = Math.min(minVal, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minVal);

            maxVal = Math.max(maxVal, prices[prices.length - 1 - i]);
            rightProfit[prices.length - 1 - i] = Math.max(rightProfit[prices.length - i], maxVal - prices[prices.length - 1 - i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        return maxProfit;
    }
}
