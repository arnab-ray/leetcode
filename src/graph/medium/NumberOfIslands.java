package graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    private class Node {
        int i, j;
        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int numIslands(char[][] grid) {
        int countIsland = 0;

        if (grid.length > 0) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        Queue<Node> q = new LinkedList<>();
                        q.add(new Node(i, j));

                        while (!q.isEmpty()) {
                            Node node = q.poll();
                            int m = node.i;
                            int n = node.j;

                            if (m - 1 >= 0 && grid[m - 1][n] == '1' && !visited[m - 1][n]) {
                                visited[m - 1][n] = true;
                                q.add(new Node(m - 1, n));
                            }
                            if (m + 1 < grid.length && grid[m + 1][n] == '1' && !visited[m + 1][n]) {
                                visited[m + 1][n] = true;
                                q.add(new Node(m + 1, n));
                            }
                            if (n - 1 >= 0 && grid[m][n - 1] == '1' && !visited[m][n - 1]) {
                                visited[m][n - 1] = true;
                                q.add(new Node(m, n - 1));
                            }
                            if (n + 1 < grid[m].length && grid[m][n + 1] == '1' && !visited[m][n + 1]) {
                                visited[m][n + 1] = true;
                                q.add(new Node(m, n + 1));
                            }
                        }
                        countIsland++;
                    }
                }
            }
        }

        return countIsland;
    }
}
