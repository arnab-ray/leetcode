package bfs.medium;

import java.util.ArrayList;
import java.util.List;

public class MakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        boolean[] visited = new boolean[n];
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            adjList[connection[0]].add(connection[1]);
            adjList[connection[1]].add(connection[0]);
        }

        int componentCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                componentCount++;
                bfsUtil(i, adjList, visited);
            }
        }

        int excessCable = connections.length - componentCount;
        if (excessCable <= 0) {
            return -1;
        } else {
            return Math.min(excessCable, componentCount - 1);
        }
    }

    private void bfsUtil(int u, List<Integer>[] adjList, boolean[] visited) {
        visited[u] = true;
        for (int v : adjList[u]) {
            if (!visited[v]) {
                bfsUtil(v, adjList, visited);
            }
        }
    }
}
