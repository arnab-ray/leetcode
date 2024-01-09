package graph.medium;

import java.util.*;

public class NetworkDelayTime {
    private static class Node {
        int i, cost;
        Node(int i, int cost) {
            this.i = i;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            adjList.get(u).add(new Node(v, time[2]));
        }

        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.cost));
        queue.add(new Node(k - 1, 0));
        dist[k - 1] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int u = node.i;

            for(Node adjNode : adjList.get(u)) {
                int v = adjNode.i;
                int weight = adjNode.cost;

                if(!visited[v] && (dist[u] + weight) < dist[v]) {
                    dist[v] = dist[u] + weight;
                    adjNode.cost = dist[v];
                    queue.add(adjNode);
                }
            }

            visited[u] = true;
        }

        int cost = 0;
        for (int distance : dist) {
            cost = Math.max(cost, distance);
        }

        return cost == Integer.MAX_VALUE ? -1 : cost;
    }
}
