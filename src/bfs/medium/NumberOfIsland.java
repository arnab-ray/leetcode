package bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    private class Node {
        int i, j;
        Node(int i, int j) {
            this.i = i; this.j = j;
        }
    }

    public int numIslands(char[][] grid) {
        int countIsland = 0;

        if(grid.length > 0) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];

            for(int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(!visited[i][j] && grid[i][j] == '1') {
                        Queue<Node> queue = new LinkedList<>();
                        queue.add(new Node(i, j));
                        visited[i][j] = true;
                        while (!queue.isEmpty()) {
                            Node node = queue.poll();
                            int m = node.i;
                            int n = node.j;
                            if(m - 1 >= 0 && grid[m - 1][n] == '1' && !visited[m - 1][n]) {
                                queue.add(new Node(m - 1, n));
                                visited[m - 1][n] = true;
                            }
                            if(m + 1 < grid.length && grid[m + 1][n] == '1' && !visited[m + 1][n]) {
                                queue.add(new Node(m + 1, n));
                                visited[m + 1][n] = true;
                            }
                            if(n - 1 >= 0 && grid[m][n - 1] == '1' && !visited[m][n - 1]) {
                                queue.add(new Node(m, n - 1));
                                visited[m][n - 1] = true;
                            }
                            if(n + 1 < grid[m].length && grid[m][n + 1] == '1' && !visited[m][n + 1]) {
                                queue.add(new Node(m, n + 1));
                                visited[m][n + 1] = true;
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
