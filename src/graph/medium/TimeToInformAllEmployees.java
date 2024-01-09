package graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeToInformAllEmployees {
    class Node {
        int i, cost;
        Node(int i, int cost) {
            this.i = i;
            this.cost = cost;
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            if(manager[i] != -1)
                adjList.get(manager[i]).add(i);
        }

        boolean[] visited = new boolean[n];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(headID, informTime[headID]));
        visited[headID] = true;

        int cost = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            cost = Math.max(cost, node.cost);

            for (Integer v : adjList.get(node.i)) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.add(new Node(v, node.cost + informTime[v]));
                }
            }
        }

        return cost;
    }
}
