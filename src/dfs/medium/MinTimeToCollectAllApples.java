package dfs.medium;

import java.util.ArrayList;
import java.util.List;

public class MinTimeToCollectAllApples {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return dfsUtil(0, adjList, visited, hasApple);
    }

    private int dfsUtil(int u, List<List<Integer>> adjList, boolean[] visited, List<Boolean> hasApple) {
        visited[u] = true;
        int total = 0;

        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                total += dfsUtil(v, adjList, visited, hasApple);
            }
        }

        if ((total > 0 || hasApple.get(u)) && u != 0)
            total += 2;

        return total;
    }
}
