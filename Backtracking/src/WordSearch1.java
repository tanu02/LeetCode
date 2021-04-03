class WordSearch1 {
    char[][] board;
    int row, col;
    String word;

    int[] rows = {0, 0, -1, 1};
    int[] cols = {1, -1, 0, 0};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        this.word = word;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (index == this.word.length()) return true; //word length

        if (i < 0 || i == row || j < 0 || j == col || board[i][j] != word.charAt(index) || board[i][j] == 1)
            return false; //exceeded boundary looking for next char means word length not reached

        board[i][j] = '1'; //visit

        for (int d = 0; d < rows.length; d++) { //explore neighbors
            if (dfs(i + rows[d], j + cols[d], index + 1)) return true; //if any direction has the answer
        }

        board[i][j] = word.charAt(index); //unvisit
        return false;
    }
}
//O(N*3^L)