package bfs.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite {

    private boolean bfsUtil(int numNodes, List<Integer>[] adjList) {
        int[] colour = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        Arrays.fill(colour, -1);

        for(int i = 0; i < numNodes; i++) {
            if(colour[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                colour[i] = 1;

                while (!queue.isEmpty()) {
                    Integer u = queue.poll();
                    for(Integer v : adjList[u]) {
                        if(colour[v] == colour[u])
                            return false;
                        else if(!visited[v]) {
                            queue.add(v);
                            visited[v] = true;
                            colour[v] = colour[u] == 1 ? 0 : 1;
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        if(graph.length == 0)
            return false;

        List<Integer>[] adjList = new LinkedList[graph.length];
        for(int i = 0; i < graph.length; i++)
            adjList[i] = new LinkedList<>();

        for(int i = 0; i < graph.length; i++) {
            for(int u : graph[i]) {
                adjList[i].add(u);
                adjList[u].add(i);
            }
        }

        return bfsUtil(graph.length, adjList);
    }
}
