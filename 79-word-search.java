class Solution {
    public boolean myFunction(char board[][], String word, int i, int row, int col) {
        if (i == word.length()) {
            return true;
        } else if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        } else if (board[row][col] != word.charAt(i)) {
            return false;
        }
        char ch = board[row][col];
        board[row][col] = ' ';
        if (myFunction(board, word, i + 1, row + 1, col) || myFunction(board, word, i + 1, row, col + 1)
                || myFunction(board, word, i + 1, row - 1, col) || myFunction(board, word, i + 1, row, col - 1)) {
            return true;
        }
        board[row][col] = ch;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (myFunction(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}