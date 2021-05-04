import java.util.Arrays;

//https://leetcode.com/problems/product-of-array-except-self/
//        238. Product of Array Except Self

public class ProductofArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) return nums;

        int[] rightSum = new int[nums.length];
        int[] output = new int[nums.length];

        rightSum[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] * nums[i + 1];
        }

        int leftSum = 1;

        for (int i = 0; i < nums.length; i++) {
            output[i] = leftSum * rightSum[i];
            leftSum *= nums[i];
        }
        return output;

    }
}

class Main5 {
    public static void main(String args[]) {
        ProductofArrayExceptSelf238 sol = new ProductofArrayExceptSelf238();

        int[] num2 = {1, 2, 3, 4}; //[24,12,8,6] output
        int[] num1 = {-1, 1, 0, -3, 3}; // [0,0,9,0,0] output
        int[] nums3 = {1, 2};
        System.out.println(Arrays.toString(sol.productExceptSelf(nums3)));

    }
}

