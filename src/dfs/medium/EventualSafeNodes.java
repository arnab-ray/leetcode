package dfs.medium;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] colour = new int[n];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(dfs(i, colour, graph)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int node, int[] colour, int[][] graph) {
        if(colour[node] > 0) return colour[node] == 2;

        colour[node] = 1;
        for(int v : graph[node]) {
            if(colour[v] == 2)
                continue;
            if(colour[v] == 1 || !dfs(v, colour, graph))
                return false;
        }

        colour[node] = 2;
        return true;
    }

}
