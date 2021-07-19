/*
198. House Robber

https://leetcode.com/problems/house-robber/
*/

import java.util.Arrays;

class HouseRobber198 {
    int[] dp;

    public int rob(int[] nums) {
        if (nums == null) return 0;

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return dp(nums, 0);
    }


    private int dp(int[] arr, int index) {
        if (index >= arr.length) return 0;

        if (dp[index] != -1) return dp[index];

        dp[index] =  Math.max(arr[index] + dp(arr, index + 2), dp(arr, index + 1));
        return dp[index];
    }
}

class Main9 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1}; //4
        int[] nums1 = {2,7,9,3,1};
        HouseRobber198 sol = new HouseRobber198();
        System.out.println(sol.rob(nums));
        System.out.println(sol.rob(nums1));//12
    }
}
