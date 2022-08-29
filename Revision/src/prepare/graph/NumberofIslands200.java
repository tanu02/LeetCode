package prepare.graph;

public class NumberofIslands200 {
    int[] rows = {1, -1, 0, 0};

    int[] cols = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] arr, int i, int j) {
        if (i < 0 || i == arr.length || j < 0 || j == arr[0].length || arr[i][j] == '0') {
            return;
        }

        arr[i][j] = '0';

        for (int k = 0; k < rows.length; k++) {
            dfs(arr, i + rows[k], j + cols[k]);
        }
    }
}
