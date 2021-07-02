//322. Coin Change
//https://leetcode.com/problems/coin-change/
//

import java.util.Arrays;

class CoinChange {
    int[] coins;
    int count;
    int target;
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.target = amount;
        count = Integer.MAX_VALUE;
        dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        backTrack(0, 0, 0);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int backTrack(int sum, int currentCoins, int index) {
        if(dp[sum] != Integer.MAX_VALUE)  return dp[sum];

        if (sum == target) {
            return 1;

        }
        if (sum > target) return 0;

        for (int i = index; i < coins.length; i++) {
           dp[sum] = Math.min(dp[sum], backTrack(sum + coins[i], currentCoins + 1, i));
        }
        return dp[sum];
    }
}

class Main{
    public static void main(String[] args) {
//        int[] coins = {1,2,5}; int amount = 11;
        int[] coins = {1,2,3}; int amount = 3;
        int[] coins1 = {2}; int amount1 = 3;
        int[] coins2 = {1}; int amount2 = 0;
        int[] coins3 = {1}; int amount3 = 1;
        int[] coins4 = {1}; int amount4 = 2;
        int[] coins5 = {411,412,413,414,415,416,417,418,419,420,421,422};
        int amount5 = 9864;

        CoinChange sol = new CoinChange();

        System.out.println(sol.coinChange(coins, amount));
//        System.out.println(sol.coinChange(coins1, amount1));
//        System.out.println(sol.coinChange(coins2, amount2));
//        System.out.println(sol.coinChange(coins3, amount3));
//        System.out.println(sol.coinChange(coins4, amount4));
    }
}

//[1 2 3]
//		0 1 2
//		Coins : c
//
//1  									2							3
//	  1				       	2	 		3						2	    3				      (3)
//	  1		2.          3				(3)			(4)						(4).    (5)					c1
//	  (3)	     (4)		(5)				c2
//	  c3						 d																		cf
