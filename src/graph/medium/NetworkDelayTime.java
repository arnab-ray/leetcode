package graph.medium;

import java.util.*;

public class NetworkDelayTime {
    class Node {
        int i, cost;
        Node(int i, int cost) {
            this.i = i;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        List<Node>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++)
            adjList[i] = new ArrayList<>();

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            adjList[u].add(new Node(v, time[2]));
        }

        for(int i = 0; i < adjList.length; i++) {
            System.out.print(i + 1 + ": ");
            for(Node v : adjList[i]) {
                System.out.print(v.i + 1 + "->");
            }
            System.out.println();
        }

        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.cost));
        queue.add(new Node(K - 1, 0));
        visited[K - 1] = true;
        dist[K - 1] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int u = node.i;

            for(Node adjNode : adjList[u]) {
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
