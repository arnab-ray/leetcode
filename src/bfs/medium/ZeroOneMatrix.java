package bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    private static class Node {
        int i, j;
        Node(int i, int j) {
            this.i = i; this.j = j;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length > 0) {
            int[][] neighbour = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            boolean[][] visited = new boolean[matrix.length][matrix[0].length];
            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        queue.add(new Node(i, j));
                        visited[i][j] = true;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int n = queue.size();

                for (int i = 0; i < n; i++) {
                    Node node = queue.poll();
                    if (node != null) {
                        for (int[] ints : neighbour) {
                            int x = node.i + ints[0];
                            int y = node.j + ints[1];

                            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y]) {
                                visited[x][y] = true;
                                queue.add(new Node(x, y));
                                matrix[x][y] = matrix[node.i][node.j] + 1;
                            }
                        }
                    }
                }
            }
        }

        return matrix;
    }
}
