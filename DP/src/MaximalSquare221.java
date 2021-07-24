/*
221. Maximal Square
https://leetcode.com/problems/maximal-square/
*/

import java.util.Arrays;

class MaximalSquare221 {
    int[][] dp;
    char[][] matrix;

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;
        this.matrix = matrix;

        dp = new int[row][col];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int maxLength = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    maxLength = Math.max(maxLength, dp(i, j));
                }
            }
        }

        return maxLength * maxLength;

    }

    private int dp(int i, int j) {
        if (i == matrix.length || j == matrix[0].length) return 0; //boundary
        if (matrix[i][j] == '0') return 0;  //not a square

        if (dp[i][j] != -1) return dp[i][j];

        if (matrix[i][j] == '1') {
            dp[i][j] = 1 + Math.min(Math.min(dp(i + 1, j), dp(i, j + 1)), dp(i + 1, j + 1));
        }
        return dp[i][j];
    }
}

class Main77 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};//4
        char[][] matrix1 = {{'0','1'},{'1','0'}};
        char[][] matrix2 =  {{'0'}};

        MaximalSquare221 sol = new MaximalSquare221();
        System.out.println(sol.maximalSquare(matrix));//4
        System.out.println(sol.maximalSquare(matrix1));//1
        System.out.println(sol.maximalSquare(matrix2));//0
    }
}