package bfs.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumJumpsToReachHome {
    private static class Node {
        int pos;
        boolean isBackward;

        Node(int pos, boolean isBackward) {
            this.pos = pos;
            this.isBackward = isBackward;
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int jumps = 0;
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<Integer> forbiddenSet = new HashSet<>();

        int maxLimit = 2000 + 2 * b;
        for (int val : forbidden) {
            forbiddenSet.add(val);
            maxLimit = Math.max(maxLimit, val + 2 * b);
        }

        queue.add(new Node(0, false));
        visited.add(0 + "," + 0);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if (node != null) {
                    if (node.pos == x) {
                        return jumps;
                    } else {
                        if (!forbiddenSet.contains(node.pos + a) && !visited.contains(node.pos + a + "," + 0) && node.pos + a < maxLimit) {
                            queue.add(new Node(node.pos + a, false));
                            visited.add(node.pos + a + "," + 0);
                        }
                        if (node.pos - b >= 0 && !forbiddenSet.contains(node.pos - b) && !visited.contains(node.pos - b + "," + 1) && !node.isBackward) {
                            queue.add(new Node(node.pos - b, true));
                            visited.add(node.pos - b + "," + 1);
                        }
                    }
                }
            }
            jumps++;
        }

        return -1;
    }
}
