package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	List<int[]> directions = Arrays.asList(
			new int[] {0, 1},
			new int[] {1, 1},
			new int [] {1, 0},
			new int [] {1, -1},
			new int [] {0, -1},
			new int [] {-1, -1},
			new int [] {-1, 0},
			new int [] {-1, 1}
			
			);
			
	int[][] visited;

	public int shortestPathBinaryMatrix(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1)
			return -1;

		visited = new int[grid.length][grid[0].length];

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });

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
				List<int[]> neightbours = getNeighbours(row, col, grid, visited);

				for (int[] neighbour : neightbours) {

					queue.add(new int[] { neighbour[0], neighbour[1] });
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
				neighbours.add(new int[] { y, x });
			}
		}
		return neighbours;
	}

	private boolean isValid(int i, int j, int[][] grid) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 1 || visited[i][j] == 1) // if
																												// not
																												// visited)
			return false;
		return true;
	}
}
