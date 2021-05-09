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