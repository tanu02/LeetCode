//152. Maximum Product Subarray
//
//		https://leetcode.com/problems/maximum-product-subarray/

public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int currMax = nums[0];
        int currMin = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int tempMax = Math.max(currMax * nums[i], currMin * nums[i]);
            int tempMin = Math.min(currMax * nums[i], currMin * nums[i]);

            currMax = Math.max(nums[i], tempMax);
            currMin = Math.min(nums[i], tempMin);

            maxProduct = Math.max(currMax, maxProduct);

        }
        return maxProduct;
    }
}

class Main1 {
    public static void main(String args[]) {
        MaximumProductSubarray152 sol = new MaximumProductSubarray152();
        int[] arr = {-4, -3, -2};
        sol.maxProduct(arr);

    }
}
