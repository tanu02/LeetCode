/*
213. House Robber II
https://leetcode.com/problems/house-robber-ii/

*/

import java.util.Arrays;

class HouseRobberII213 {

    public int rob(int[] nums) {
        if (nums == null) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int rob1 = nums[0] + dp(nums, 2, dp, nums.length - 1); //if there is 1 element then dp will return 0 hence add it here
        Arrays.fill(dp, -1);
        int rob2 = dp(nums, 1, dp, nums.length);
        return Math.max(rob1, rob2);

    }

    private int dp(int[] arr, int index, int[] dp, int length) {
        if (index >= length) return 0;

        if (dp[index] != -1) return dp[index];

        dp[index] = Math.max(arr[index] + dp(arr, index + 2, dp, length),
                dp(arr, index + 1, dp, length));
        return dp[index];
    }

}

class Main0 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2}; //3
        int[] nums1 = {1, 2, 3, 1};//4
        int[] nums2 ={1};
        HouseRobberII213 sol = new HouseRobberII213();
        System.out.println(sol.rob(nums));
        System.out.println(sol.rob(nums1));
        System.out.println(sol.rob(nums2));
    }
}
