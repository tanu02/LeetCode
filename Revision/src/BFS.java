import java.util.*;
import java.util.LinkedList;

public class BFS {
}
//317. Shortest Distance from All Buildings
//https://leetcode.com/problems/shortest-distance-from-all-buildings/
class ShortestDistancefromAllBuildings317 {
    int[][] reach;
    int[][] dist;
    int[][] grid;
    int row;
    int col;

    List<int[]> directions = Arrays.asList(new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 0, -1 },
            new int[] { -1, 0 });

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        row = grid.length;
        col = grid[0].length;

        reach = new int[row][col];
        dist = new int[row][col];
        this.grid = grid;

        int totalBuildings = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) { //valid building
                    bfs(i, j);
                    totalBuildings++;
                }

            }
        }

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) { //building which can be reached from all the buildings
            for (int j = 0; j < col; j++) {
                if (reach[i][j] == totalBuildings && dist[i][j] < minDis) { //reachable from all the buildings then check whose has min distance
                    minDis = dist[i][j];
                }

            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    private void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[row][col];

        queue.add(new int[] { i, j });
        int dis = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            dis++; // this distance is for neighbours
            for (int m = 0; m < size; m++) { // level
                int[] currentBuilding = queue.poll();

                for (int[] dir : directions) { // child
                    int rr = currentBuilding[0] + dir[0];
                    int cc = currentBuilding[1] + dir[1];

                    if (isValid(visited, rr, cc)) { //building(1) which exists(!= length) and not visited (!= 2)
                        queue.add(new int[] { rr, cc });
                        visited[rr][cc] = 2;
                        reach[rr][cc]++;  //current building is reachable from parent
                        dist[rr][cc] += dis;
                    }
                }
            }

        }

    }

    private boolean isValid(int[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i == row || j == col || grid[i][j] == 2 ||
                grid[i][j] == 1 || visited[i][j] == 2)
            return false;

        return true;
    }
}

//-------


class ShortestPathinBinaryMatrix1091 {
    List<int[]> directions = Arrays.asList(
            new int[]{0, 1},
            new int[]{1, 1},
            new int[]{1, 0},
            new int[]{1, -1},
            new int[]{0, -1},
            new int[]{-1, -1},
            new int[]{-1, 0},
            new int[]{-1, 1}

    );

    int[][] visited;

    public int shortestPathBinaryMatrix(int[][] grid) {//from start till end

        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1)
            return -1;

        visited = new int[grid.length][grid[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                if (row == grid.length - 1 && col == grid[0].length - 1)
                    return count; // dest

                visited[row][col] = 1; // mark visited
                List<int[]> neighbours = getNeighbours(row, col, grid, visited);

                for (int[] neighbour : neighbours) {

                    queue.add(new int[]{neighbour[0], neighbour[1]});
                }

            }
        }
        return -1;
    }

    private List<int[]> getNeighbours(int i, int j, int[][] grid, int[][] visited) {
        List<int[]> neighbours = new ArrayList<>();

        for (int[] dir : directions) { // neighbours
            int y = i + dir[0];
            int x = j + dir[1];
            if (isValid(y, x, grid)) {
                neighbours.add(new int[]{y, x});
            }
        }
        return neighbours;
    }

    private boolean isValid(int i, int j, int[][] grid) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 1 || visited[i][j] == 1) // if not visited
            return false;   //we have to find path of 0s
        return true;
    }
}
//given 0,0 to mn - 1 position find shortest distance
//    0 ->   0 ->  0
//    1      1     0
//    1      1     0
