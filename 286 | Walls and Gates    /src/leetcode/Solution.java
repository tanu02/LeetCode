package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Solution { // O(MN)
    private static final int INF = 2147483647;
    private static final int WALL = -1;
    private static final int GATE = 0;

    int[] rows = {0, 0, 1, -1};
    int[] cols = {1, -1, 0, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == GATE)
                    queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int r = point[0], c = point[1];

            for (int i = 0; i < rows.length; i++) {
                int rr = r + rows[i], cc = c + cols[i];

                if (isValid(rooms, rr, cc)) {
                    rooms[rr][cc] = rooms[r][c] + 1; //increase distance of gate by 1
                    queue.add(new int[]{rr, cc});
                }
            }

        }

    }

    private boolean isValid(int[][] rooms, int i, int j) {
        if (i < 0 || i == rooms.length || j < 0 || j == rooms[0].length || rooms[i][j] != INF)
            return false; //inf means  empty room and we have only fill empty rooms

        return true;
    }
}