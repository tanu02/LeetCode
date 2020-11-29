package leetcode;

class Solution {
	int row = 0;
	int col = 0;

	public int numIslands(char[][] grid) {

		int count = 0;
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return count;
		this.row = grid.length;
		this.col = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (grid[i][j] == '1') {
					count++;
					conquer(grid, i, j);
				}
			}
		}
		return count;
	}

	private void conquer(char[][] arr, int i, int j) {
		if (j == col || j < 0 || i < 0 || i == row)
			return;

		if (arr[i][j] == '1') {

			arr[i][j] = '2';

			conquer(arr, i, j + 1); // r
			conquer(arr, i, j - 1); //l
			conquer(arr, i - 1, j); //u
			conquer(arr, i + 1, j); //d
		}
	}
}