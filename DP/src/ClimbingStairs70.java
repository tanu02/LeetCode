/*
70. Climbing Stairs

https://leetcode.com/problems/climbing-stairs/

*/
import java.util.Arrays;

class ClimbingStairs70 {
    int[] dp;

    public int climbStairs(int n) {  //. Knapsack 
        if (n == 0) return 0;

        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dp(n);
    }

    private int dp(int sum) {
        if (sum == 0) return 1;
        if (sum < 0) return 0;

        if (dp[sum] != -1) return dp[sum];

        dp[sum] = dp(sum - 1) + dp(sum - 2);
        return dp[sum];

    }

}