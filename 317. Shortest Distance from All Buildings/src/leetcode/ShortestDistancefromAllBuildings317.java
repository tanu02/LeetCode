package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
				if (grid[i][j] == 1) {
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
			dis++; // same level same distance
			for (int m = 0; m < size; m++) { // level
				int[] build = queue.poll();

				for (int[] dir : directions) { // child
					int y = build[0] + dir[0];
					int x = build[1] + dir[1];

					if (isValid(visited, y, x)) { //building(1) which exists(!= length) and not visited (!= 2)
						queue.add(new int[] { y, x });
						visited[y][x] = 2;
						reach[y][x]++;
						dist[y][x] += dis;
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