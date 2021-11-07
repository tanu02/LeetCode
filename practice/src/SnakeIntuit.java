import java.util.LinkedList;
import java.util.Queue;

public class SnakeIntuit {

    int[] rows = {1, -1, 0, 0};

    int[] cols = {0, 0, 1, -1};

    public static void main(String[] args) {
    }

    private int[] findExit(int[][] board, int row, int col) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new int[0];
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dis = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col});
        int dist = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            dist++;
            for (int i = 0; i < rows.length; i++) {
                int r = curr[0] + rows[i];
                int c = curr[1] + cols[i];
                if (r > 0 && r < m && c > 0 && c < n && !visited[r][c]) {
                    dis[r][c] += dist;
                    q.offer(new int[] {r, c});
                    visited[r][c] = true;
                }
            }
        }

        int[] res = new int[0];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if(dis[i][j] > 0){
                        if (dis[i][j] == minLen) {
                            if (i + j < res[0] + res[1]) {
                                res = new int[] {i, j};
                            }
                        } else {
                            minLen = Math.min(minLen, dis[i][j]);
                            res = new int[] {i, j};
                        }
                    }
                }
            }
        }
        return res;

    }

}
