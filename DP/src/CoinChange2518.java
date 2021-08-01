//518. Coin Change 2
//https://leetcode.com/problems/coin-change-2/

import java.util.Arrays;

class CoinChange2518 {
    int[] coins;
    int dp[][];

    public int change(int amount, int[] coins) { // number of combinations
        if (amount == 0) return 1;

        this.coins = coins;
        this.dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dp(amount, 0);
    }

    private int dp(int index, int sum) {
        if (sum == 0) return 1;
        if (sum < 0) return 0;

        if (dp[index][sum] != -1) return dp[index][sum];

        int ans = 0;
        for (int i = index; i < coins.length; i++) {
            ans += dp(sum - coins[i], i);
        }
        dp[index][sum] = ans;
        return dp[index][sum];
    }
}
//Every state has weight plus different dataset for example
//left most 1 has 1,2,3 + weight 1
//middle 1 has 2, 3 + weight 1

class Main8 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        CoinChange2518 sol = new CoinChange2518();
        System.out.println(sol.change(amount, coins));//4

        int amount1 = 3;
        int[] coins1 = {2};
        System.out.println(sol.change(amount1, coins1));//0

        int amount2 = 0;
        int[] coins2 = {7};
        System.out.println(sol.change(amount2, coins2)); //1

        int[] coins3 = {3,5,7,8,9,10,11};
        int amount3 = 500;
        System.out.println(sol.change(amount3  , coins3)); //1
    }
}
