package bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }

        if (queue.size() == 0 || queue.size() == grid.length * grid[0].length)
            return -1;

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                if (p != null) {
                    for (int j = 0; j < 4; j++) {
                        int x = p.x + dirX[j];
                        int y = p.y + dirY[j];

                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) {
                            grid[x][y] = 1;
                            queue.add(new Point(x, y));
                        }
                    }
                }
            }

            distance++;
        }

        return distance - 1;
    }
}
