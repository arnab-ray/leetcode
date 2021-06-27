package dfs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        List<Integer> queue = new LinkedList<>();
        queue.add(0);
        dfsUtil(0, graph, queue, visited, result);

        return result;
    }

    private void dfsUtil(Integer node, int[][] graph, List<Integer> queue, boolean[] visited, List<List<Integer>> result) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(queue));
        } else {
            visited[node] = true;
            for (Integer i : graph[node]) {
                if (!visited[i]) {
                    queue.add(i);
                    dfsUtil(i, graph, queue, visited, result);
                    queue.remove(i);
                }
            }
            visited[node] = false;
        }
    }
}
