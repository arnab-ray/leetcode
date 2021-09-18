package bfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        for(int i = 0; i < flights.length; i++) {
            adjList[flights[i][0]].add(new int[] {flights[i][1], flights[i][2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {src, 0, 0});

        while(!pq.isEmpty()) {
            int[] u = pq.poll();
            if(u[0] == dst)
                return u[1];
            if(u[2] > K || (dist[u[0]] != -1 && dist[u[0]] < u[2]))
                continue;

            dist[u[0]] = u[2];
            for(int[] e : adjList[u[0]]) {
                pq.add(new int[]{e[0], u[1] + e[1], u[2] + 1});
            }

        }

        return -1;

    }
}
