package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	int row, col;
	boolean[][] visited;

	List<int[]> directions = Arrays.asList(new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 0, -1 },
			new int[] { -1, 0 });
	int[][] grid;

	public int numDistinctIslands(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		this.row = grid.length;
		this.col = grid[0].length;
		this.grid = grid;
		visited = new boolean[row][col];
		Set<List<Integer>> islandsSet = new HashSet<>();
		List<Integer> island;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					island = new ArrayList<>();
					dfs(island, i, j, 0);
					if (!island.isEmpty())
						islandsSet.add(island);
				}
			}
		}
		return islandsSet.size();
	}

	private void dfs(List<Integer> island, int i, int j, int dis) {
		if (i < 0 || i == row || j < 0 || j == col || grid[i][j] == 0 || visited[i][j])
			return;

		visited[i][j] = true;
		island.add(dis);

		for (int[] dir : directions) {
			dfs(island, i + dir[0], j + dir[1], dis++);
		}
		island.add(0);

	}
}
