package leetcode;

import java.util.Arrays;
import java.util.List;

class Solution {
	char[][] board;
	int row, col;
	String word;
	List<int[]> directions = Arrays.asList(new int[] { 0, 1 },
			new int[] { 1, 0 }, new int[] { 0, -1 },
			new int[] { -1, 0 });

	public boolean exist(char[][] board, String word) {
		this.board = board;
		this.row = board.length;
		this.col = board[0].length;
		this.word = word;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(i, j, 0))
					return true;
				;
			}
		}
		return false;
	}

	private boolean dfs(int i, int j, int index) {
		if (index == this.word.length())
			return true;

		if (i < 0 || i == row || j < 0 || j == col || board[i][j] != word.charAt(index) || board[i][j] == 1)
			return false;

		board[i][j] = '1';
		boolean isFound = false;

		for (int[] direct : directions) {
			isFound = dfs(direct[0] + i, direct[1] + j, index + 1);
			if (isFound)
				return true;
		}

		board[i][j] = word.charAt(index);
		return isFound;
	}
}