package leetcode;

import java.util.Arrays;
import java.util.List;

class Solution {
	int per ;
	int ROW;
	int COL;
	int[][] grid;
	int[][] visited;
	int[] arr = { 1, 2 };
	List<int[]> directions = Arrays.asList(new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 0, -1 },
			new int[] { -1, 0 });

	public int islandPerimeter(int[][] grid) {
		per = 0;
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		this.ROW = grid.length;
		this.COL = grid[0].length;
		this.grid = grid;
		this.visited = new int[ROW][COL];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				dfs(i, j);
			}
		}
		return per;
	}

	private int dfs(int i, int j) {
		if (i < 0 || i == ROW || j < 0 || j == COL || grid[i][j] == 0)
			return 0;
		if (visited[i][j] == 2)
			return 2;
		
		visited[i][j] = 2;

		for (int[] dir : directions) {
			if (dfs(i + dir[0], j + dir[1]) == 0)
				this.per++;
		}

		return 2;

	}
}