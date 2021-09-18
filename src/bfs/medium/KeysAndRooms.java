package bfs.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(0);

        while(!queue.isEmpty()) {
            Integer u = queue.poll();
            visited[u] = true;
            for(int v : rooms.get(u)) {
                if(!visited[v])
                    queue.add(v);
            }
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }

}
