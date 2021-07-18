//322. Coin Change
//https://leetcode.com/problems/coin-change/
//

import java.util.Arrays;

class CoinChange322 {

    int[] dp;
    int[] coins;

    public int coinChange(int[] coins, int amount) { //min number of coins

        if(amount == 0) return 0;

        dp = new int[amount + 1];
        this.coins = coins;

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp(amount);
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    private int dp(int sum) {

        if (sum == 0) return 0;
        if (sum < 0)
            return -1; //don't return max it might seem obvious, but at this state -1 means there is no path through unlike returning inf means there are inf number of  coins
        if (dp[sum] != Integer.MAX_VALUE) return dp[sum];

        int ans = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            ans = dp(sum - coins[i]);                //min on a given level
            if (ans != -1) min = Math.min(ans, min);
        }

        dp[sum] = min == Integer.MAX_VALUE ? -1 : min + 1;
        return dp[sum];
    }

}

class Main7 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChange322 sol = new CoinChange322();
        int[] coins2 = {1, 2, 3};
        int amount2 = 3;
        System.out.println(sol.coinChange(coins2, amount2));//1
        System.out.println(sol.coinChange(coins, amount));//3

        int[] coins1 = {2};
        int amount1 = 3;
        System.out.println(sol.coinChange(coins1, 0));//-1
    }
}
