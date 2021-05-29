//1631. Path With Minimum Effort
//https://leetcode.com/problems/path-with-minimum-effort/

import java.util.*;

//Dijkstra
class PathWithMinimumEffort1631 {
    int[] rows = {0, 0, 1, -1};
    int[] cols = {1, -1, 0, 0};

    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length == 0) return -1;

//queue comparator
        Queue<Node> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.eff, n2.eff));
        queue.offer(new Node(new int[]{0, 0}, 0));
//visited
        Set<Node> visited = new HashSet<>();
//efforts
        int[][] effort = new int[heights.length][heights[0].length];
        for (int[] arr : effort) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

//logic - > poll,  check visited,  visit, valid neighbors, if eff is less then enqueue
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int r = node.loc[0];
            int c = node.loc[1];
            int currEff = node.eff;

            if (r == heights.length - 1 && c == heights[0].length - 1) return currEff;
            if (visited.contains(node)) continue;
            visited.add(node);

            for (int i = 0; i < rows.length; i++) {
                int rr = r + rows[i];
                int cc = c + cols[i];
                if (!isValid(rr, cc, heights)) continue;

                int edge = Math.abs(heights[rr][cc] - heights[r][c]);
                int eff = Math.max(currEff, edge);

                if (eff < effort[rr][cc]) {
                    queue.offer(new Node(new int[]{rr, cc}, eff));
                    effort[rr][cc] = eff;
                }
            }
        }

        return -1;
    }

    private boolean isValid(int row, int col, int[][] heights) {
        if (row < 0 || row == heights.length || col < 0 || col == heights[0].length) return false;
        return true;
    }

    class Node {
        int[] loc;
        int eff;

        Node(int[] loc, int eff) {
            this.loc = loc;
            this.eff = eff;
        }
    }

}


class Main00 {
    public static void main(String[] args) {
        PathWithMinimumEffort1631 sol = new PathWithMinimumEffort1631();
        int[][] heights = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        System.out.println(sol.minimumEffortPath(heights));//0

        int[][] heights1 = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        System.out.println(sol.minimumEffortPath(heights1));//1

        int[][] heights2 = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(sol.minimumEffortPath(heights2));//2

    }
}