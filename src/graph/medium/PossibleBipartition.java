package graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition {
    private boolean bfsUtil(int i, boolean[] visited, int[] colour, List<Integer>[] adjList) {
        visited[i] = true;
        colour[i] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            for(Integer v : adjList[u]) {
                if (colour[v] == colour[u])
                    return false;
                if(!visited[v]) {
                    colour[v] = colour[u] == 1 ? 2 : 1;
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        return true;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(N == 0 || N == 1)
            return true;

        boolean[] visited = new boolean[N];
        int[] colour = new int[N];

        List<Integer>[] adjList = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            adjList[dislike[0] - 1].add(dislike[1] - 1);
            adjList[dislike[1] - 1].add(dislike[0] - 1);
        }

        boolean result = true;
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                result = bfsUtil(i, visited, colour, adjList);
            }

            if(!result)
                break;
        }

        return result;
    }
}
