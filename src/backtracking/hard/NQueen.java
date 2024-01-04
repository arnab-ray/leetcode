package backtracking.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    private boolean isValidPlacement(char[][] board, int row, int col) {
        if (row >= board.length || col >= board.length) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            // check for column in the given row or row in given column
            if (board[row][i] == 'Q' || board[i][col] == 'Q')
                return false;
        }

        // check for diagonal
        int maxLen = Math.min(row, col);
        for (int i = 1; i <= maxLen && row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i] == 'Q')
                return false;
        }

        maxLen = Math.max(row, board.length - 1 - col);
        for (int i = 1; i <= maxLen && row - i >= 0 && col + i < board.length; i++) {
            if (board[row - i][col + i] == 'Q')
                return false;
        }

        return true;
    }

    private void solveNQueenUtil(List<List<String>> result, int row, char[][] board) {
        if (row >= board.length) {
            result.add(getBoardConfig(board));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isValidPlacement(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueenUtil(result, row + 1, board);
                board[row][col] = '.';
            }
        }
    }

    private List<String> getBoardConfig(char[][] board) {
        List<String> result = new ArrayList<>();

        for (char[] chars : board) {
            String row = new String(chars);
            result.add(row);
        }

        return result;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n == 0) return result;
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        solveNQueenUtil(result, 0, board);
        return result;
    }
}
