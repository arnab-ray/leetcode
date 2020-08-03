package graph.medium;

import java.util.*;

public class ReconstructItinerary {
    private void dfsUtil(String u, Map<String, PriorityQueue<String>> map, List<String> result) {
        PriorityQueue<String> adjList = map.get(u);
        while (adjList != null && !adjList.isEmpty()) {
            dfsUtil(adjList.poll(), map, result);
        }

        result.add(0, u);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new TreeMap<>();

        for(List<String> ticket : tickets) {
            PriorityQueue<String> list = map.getOrDefault(ticket.get(0), new PriorityQueue<>());
            list.add(ticket.get(1));
            map.put(ticket.get(0), list);
        }

        List<String> result = new LinkedList<>();
        dfsUtil("JFK", map, result);

        return result;
    }
}
