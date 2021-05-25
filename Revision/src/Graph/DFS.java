package Graph;

public class DFS {
}

class NumberofIslands200 {
    int[] rows = {0, 0, 1, -1};
    int[] cols = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {

        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return count;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != '1')
            return; //boundary or already visited or is not an island

        grid[i][j] = '0'; //visit

        for (int x = 0; x < rows.length; x++) {
            dfs(grid, i + rows[x], j + cols[x]); //conquer neighbors
        }
    }
}

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
        return false; //every state says if you consider me there is no path
    }
}
//O(N*3^L)

//chill
//word search
//             n1                 n2 || n3   if any works return true
//        n2          n3
//                                return false [none worked]
//

//strict
//bipartite,
//              n1                 n2 && n3 if any did not work return false;
//        n2          n3
//                                return true [all worked]


//When to mark a node visited?
//                n1 -> n2 -> n3
//                    <------
//if you return back to n1 from n3 and start processing n2 - will give a loop
// hence visit n1
// Graph.Graph.Dijkstra, island problems, normal dfs

//        n1 -> n2 -> n3
//            <------
//Euler path - every time we visit a node we remove an edge be revisiting same node
//so no need to mark visited
//we are removing the edges[graph is manipulated] unlike above problems














