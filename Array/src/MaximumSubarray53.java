//53. Maximum Subarray
//        https://leetcode.com/problems/maximum-subarray/

class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], nums[i] + currSum);
            if (currSum > maxSum) maxSum = currSum;
        }
        return maxSum;
    }
}