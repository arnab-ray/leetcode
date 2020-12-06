package bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private static class Node {
        int i, j;
        Node(int i, int j) {
            this.i = i; this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        int timer = 0;
        if (grid.length > 0) {
            int[][] neighbour = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new Node(i, j));
                    }
                }
            }

            if (!queue.isEmpty())
                timer = -1;

            while (!queue.isEmpty()) {
                int n = queue.size();
                //System.out.println("queue size: " + n);
                for (int i = 0; i < n; i++) {
                    Node node = queue.poll();
                    if (node != null) {
                        for (int[] ints : neighbour) {
                            int x = node.i + ints[0];
                            int y = node.j + ints[1];

                            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                                queue.add(new Node(x, y));
                                grid[x][y] = 2;
                            }
                        }
                    }
                }
                timer++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return timer;
    }
}
