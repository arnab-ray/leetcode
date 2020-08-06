package backtracking.medium;

public class WordSearch {
    private boolean existUtil(char[][] board, int i, int j, boolean[][] visited, String word, int pos) {
        if(visited[i][j]) {
            return false;
        }
        if(pos == word.length() - 1) {
            return board[i][j] == word.charAt(pos);
        }
        if(board[i][j] != word.charAt(pos)) {
            return false;
        } else {
            boolean result = false;
            visited[i][j] = true;
            if(i < board.length - 1 && !visited[i + 1][j])
                result = existUtil(board, i + 1, j, visited, word, pos + 1);
            if(i > 0 && !visited[i - 1][j])
                result = result || existUtil(board, i - 1, j, visited, word, pos + 1);
            if(j < board[0].length - 1 && !visited[i][j + 1])
                result = result || existUtil(board, i, j + 1, visited, word, pos + 1);
            if(j > 0 && !visited[i][j - 1])
                result = result || existUtil(board, i, j - 1, visited, word, pos + 1);

            visited[i][j] = false;
            return result;
        }
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(existUtil(board, i, j, visited, word, 0))
                    return true;
            }
        }

        return false;
    }
}
