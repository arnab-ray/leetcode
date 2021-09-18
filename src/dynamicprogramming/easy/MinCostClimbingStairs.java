package dynamicprogramming.easy;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] finalCost = new int[cost.length];
        finalCost[0] = cost[0]; finalCost[1] = cost[1];
        for(int i = 2; i < finalCost.length; i++) {
            finalCost[i] = Math.min(finalCost[i - 1], finalCost[i - 2]) + cost[i];
        }

        return Math.min(finalCost[finalCost.length - 1], finalCost[finalCost.length - 2]);
    }
}
