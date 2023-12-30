package dfs.medium;

import java.util.ArrayList;
import java.util.List;

public class CountSubIslands {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        List<List<Point>> islands = new ArrayList<>();
        boolean[][] visited = new boolean[grid2.length][grid2[0].length];

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (!visited[i][j] && grid2[i][j] == 1) {
                    List<Point> island = new ArrayList<>();
                    dfsUtil(i, j, grid2, visited, island);
                    islands.add(island);
                }
            }
        }

        int count = 0;
        for (List<Point> island : islands) {
            boolean flag = true;
            for (Point p : island) {
                if (grid1[p.x][p.y] == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                count++;
        }

        return count;
    }

    private void dfsUtil(int startX, int startY, int[][] grid2, boolean[][] visited, List<Point> points) {
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        visited[startX][startY] = true;
        points.add(new Point(startX, startY));

        for (int i = 0; i < 4; i++) {
            int x_ = startX + x[i];
            int y_ = startY + y[i];
            if (x_ >= 0 && x_ < grid2.length && y_ >= 0 && y_ < grid2[0].length && grid2[x_][y_] == 1 && !visited[x_][y_]) {
                dfsUtil(x_, y_, grid2, visited, points);
            }
        }
    }
}
