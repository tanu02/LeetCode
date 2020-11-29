package leetcode;

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int i = matrix.length - 1;
		int j = 0;
		int col = matrix[0].length;

		while (i >= 0 && j < col) {

			if (target > matrix[i][j])
				j++;
			else if (target < matrix[i][j])
				i--;
			else if (target == matrix[i][j])
				return true;
		}
		return false;

	}
}