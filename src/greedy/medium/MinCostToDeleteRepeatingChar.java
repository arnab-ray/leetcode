package greedy.medium;

public class MinCostToDeleteRepeatingChar {
    public int minCost(String s, int[] cost) {
        int totalCost = 0, start = 0, end = 1;
        while (end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                if (cost[start] < cost[end]) {
                    totalCost += cost[start];
                    start = end;
                } else {
                    totalCost += cost[end];
                }
            } else {
                start = end;
            }
            end++;
        }

        return totalCost;
    }
}
