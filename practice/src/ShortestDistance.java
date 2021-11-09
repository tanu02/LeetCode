import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {
    int[] rows = {0, 0, 1, -1};

    int[] cols = {1, -1, 0, 0};

    int[][] grid;

    int[][] dis;

    int[][] reach;

    public static void main(String[] args) {

    }

    int EMPTY = 0;

    int BUILDING = 1;

    int OBSTACLE = 2;

    public int shortestDistance(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        this.grid = grid;

        int m = grid.length, n = grid[0].length;
        dis = new int[m][n];
        reach = new int[m][n];
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == BUILDING) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reach[i][j] == count) {
                    minDis = Math.min(minDis, dis[i][j]);
                }
            }
        }
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    private void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        int dist = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            dist++;
            for (int k = 0; k < rows.length; k++) {
                int r = curr[0] + rows[i];
                int c = curr[1] + cols[i];

                if (r > 0 && r < m && c > 0 && c < n && !visited[r][c] && grid[r][c] == 0) {
                    dis[r][c] += dist;
                    reach[r][c]++;
                    visited[r][c] = true;
                    q.offer(new int[] {r, c});
                }
            }

        }
    }

}
