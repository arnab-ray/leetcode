package bfs.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticOcean {
    private static class Node {
        int i, j;
        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new LinkedList<>();
        if (matrix.length > 0) {
            boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
            boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < matrix.length; i++) {
                pacific[i][0] = true;
                queue.add(new Node(i, 0));
            }

            for (int i = 0; i < matrix[0].length; i++) {
                pacific[0][i] = true;
                queue.add(new Node(0, i));
            }

            bfsUtil(queue, pacific, matrix);

            for (int i = 0; i < matrix.length; i++) {
                atlantic[i][matrix[0].length - 1] = true;
                queue.add(new Node(i, matrix[0].length - 1));
            }

            for (int i = 0; i < matrix[0].length; i++) {
                atlantic[matrix.length - 1][i] = true;
                queue.add(new Node(matrix.length - 1, i));
            }

            bfsUtil(queue, atlantic, matrix);

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        List<Integer> list = new LinkedList<>();
                        list.add(i); list.add(j);
                        result.add(list);
                    }
                }
            }
        }

        return result;
    }

    private void bfsUtil(Queue<Node> queue, boolean[][] ocean, int[][] matrix) {
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n ; i++) {
                Node node = queue.poll();
                if (node != null) {
                    if (node.i - 1 >= 0 && !ocean[node.i - 1][node.j] && matrix[node.i - 1][node.j] >= matrix[node.i][node.j]) {
                        ocean[node.i - 1][node.j] = true;
                        queue.add(new Node(node.i - 1, node.j));
                    }
                    if (node.i + 1 < matrix.length && !ocean[node.i + 1][node.j] && matrix[node.i + 1][node.j] >= matrix[node.i][node.j]) {
                        ocean[node.i + 1][node.j] = true;
                        queue.add(new Node(node.i + 1, node.j));
                    }
                    if (node.j - 1 >= 0 && !ocean[node.i][node.j - 1] && matrix[node.i][node.j - 1] >= matrix[node.i][node.j]) {
                        ocean[node.i][node.j - 1] = true;
                        queue.add(new Node(node.i, node.j - 1));
                    }
                    if (node.j + 1 < matrix[0].length && !ocean[node.i][node.j + 1] && matrix[node.i][node.j + 1] >= matrix[node.i][node.j]) {
                        ocean[node.i][node.j + 1] = true;
                        queue.add(new Node(node.i, node.j + 1));
                    }
                }
            }
        }
    }
}
