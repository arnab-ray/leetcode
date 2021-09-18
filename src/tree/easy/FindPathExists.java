package tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindPathExists {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        for(int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }


        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            Integer u = queue.poll();
            for(Integer v : adjList[u]) {
                if(!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }

        return visited[end];
    }
}
