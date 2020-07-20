package bfs.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadder {
    private class Node {
        int val;
        int level;

        Node(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    private class Cell {
        int i, j;
        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private void createMap(int[][] board, Map<Integer, Cell> map) {
        int rowLength = board.length;
        int columnLength = board.length;

        boolean leftToRight = true;
        int cellNum = 0;

        for(int i = rowLength - 1; i >= 0; i--) {
            if(leftToRight) {
                for(int j = 0; j < columnLength; j++) {
                    map.put(++cellNum, new Cell(i, j));
                }
            } else {
                for(int j = columnLength - 1; j >= 0; j--) {
                    map.put(++cellNum, new Cell(i, j));
                }
            }
            leftToRight = !leftToRight;
        }
    }

    public int snakesAndLadders(int[][] board) {
        if(board.length > 0) {
            Map<Integer, Cell> map = new HashMap<>();
            createMap(board, map);

            int totalPlaces = board.length * board.length;
            boolean[] visited = new boolean[totalPlaces];
            Queue<Node> queue = new LinkedList<>();

            queue.add(new Node(1,0));
            visited[0] = true;

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if(node.val == totalPlaces)
                    return node.level;

                for (int i = 1; i <= 6; i++) {
                    Cell cell = map.get(node.val + i);
                    if(node.val + i - 1 < totalPlaces && !visited[node.val + i - 1]) {
                        visited[node.val + i - 1] = true;
                        if(board[cell.i][cell.j] == -1) {
                            queue.add(new Node(node.val + i, node.level + 1));
                        } else {
                            queue.add(new Node(board[cell.i][cell.j], node.level + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
