/*
62. Unique Paths
https://leetcode.com/problems/unique-paths/
*/


import java.util.Arrays;

class UniquePaths62 {
    int[][] dp;
    int row, col;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        row = m;
        col = n;
        return dp(0, 0);

    }

    private int dp(int i, int j) {
        if (i == row || j == col) return 0;
        if (i == row - 1 && j == col - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = dp(i, j + 1) + dp(i + 1, j);
        return dp[i][j];
    }
} 