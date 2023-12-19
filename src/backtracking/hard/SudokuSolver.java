package backtracking.hard;

public class SudokuSolver {
    private boolean isValidPlacement(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            // if num in any row of the given column matches, then the placement is invalid.
            if (board[i][col] == num)
                return false;

            // if the num in any col of the given row matches, then the placement is invalid
            if (board[row][i] == num)
                return false;

            // Check 3 X 3 subgrid
            int subgridRow = 3 * (row / 3) + i / 3; // Calculate row index of subgrid
            int subgridCol = 3 * (col / 3) + i % 3; // Calculate column index of subgrid

            if (board[subgridRow][subgridCol] == num)
                return false;
        }

        return true;
    }

    private boolean solveUtil(char[][] board, int row, int col) {
        if (row == board.length)
            return true;

        if (col == board[0].length)
            return solveUtil(board, row + 1, 0);

        if (board[row][col] != '.')
            return solveUtil(board, row, col + 1);

        for (char num = '1'; num <= '9'; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num;
                if (solveUtil(board, row, col + 1))
                    return true;
                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        solveUtil(board, 0, 0);
    }
}
