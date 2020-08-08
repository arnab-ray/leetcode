package graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {

        int[] dx = {-1,-1,-1, 0, 0, 1,1,1};
        int[] dy = {-1, 0, 1,-1, 1, -1,0,1};

        int m = board.length, n = board[0].length;
        int x = click[0], y = click[1];

        if(board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {x, y});

            while (!queue.isEmpty()) {
                int[] currentCell = queue.poll();
                int count = 0;
                Queue<int[]> secondaryQueue = new LinkedList<>();
                for(int i = 0; i < 8; i++) {
                    int x_ = currentCell[0] + dx[i];
                    int y_ = currentCell[1] + dy[i];

                    if(x_ >= 0 && x_ < m && y_ >= 0 && y_ < n) {
                        if(board[x_][y_] == 'M' || board[x_][y_] == 'X') {
                            count++;
                        } else if(board[x_][y_] == 'E') {
                            board[x_][y_] = 'B';
                            secondaryQueue.add(new int[] {x_, y_});
                        }
                    }
                }

                if(count > 0) {
                    board[currentCell[0]][currentCell[1]] = (char) ('0' + count);
                    for(int[] cell : secondaryQueue)
                        board[cell[0]][cell[1]] = 'E';
                } else {
                    board[currentCell[0]][currentCell[1]] = 'B';
                    queue.addAll(secondaryQueue);
                }
            }
        }

        return board;
    }
}
