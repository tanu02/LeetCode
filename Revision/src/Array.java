import java.util.*;

public class Array {

    //https://leetcode.com/problems/subarray-sum-equals-k/
    class SubarraySumEqualsK560 {
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;

            Map<Integer, Integer> prefixMap = new HashMap<>();
            prefixMap.put(0, 1); //0 to ith index whole array's sum equals k, 0 is a notch to extract subarray
            int count = 0;      //now that index could be the first element as well
            int currSum = 0;

            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];
                if (prefixMap.containsKey(currSum - k)) count += prefixMap.get(currSum - k);
                prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);
            }
            return count;
        }
    }

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

    //https://leetcode.com/problems/two-sum/
    public class TwoSum {
        public int[] twoSum(int[] nums, int target) {

            if (nums == null || nums.length == 0) return new int[0];

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i]))
                    return new int[]{i, map.get(target - nums[i])};

                map.put(nums[i], i);
            }
            return new int[0];
        }
    }

    public class TwoSumSorted {
        public int[] twoSum(int[] numbers, int target) {

            if (numbers == null || numbers.length == 0) return numbers;

            int left = 0, right = numbers.length - 1;

            while (left < right) {

                int sum = numbers[left] + numbers[right];

                if (sum < target) left++;
                else if (sum > target) right--;

                return new int[]{left, right};

            }
            return new int[]{-1, -1};
        }
    }

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

    class Sum3 {

        public List<List<Integer>> threeSum(int[] nums) {

            if (nums == null || nums.length < 3) return new ArrayList<>();

            Arrays.sort(nums);
            List<List<Integer>> outputList = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) continue;
                findTwoSum(i, nums, outputList);
            }

            return outputList;
        }

        private void findTwoSum(int index, int[] nums, List<List<Integer>> outputList) {

            int left = index + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[index] + nums[left] + nums[right];

                if (sum < 0) left++;
                else if (sum > 0) right--;

                else {
                    List<Integer> ans = Arrays.asList(nums[index], nums[left], nums[right]);
                    outputList.add(new ArrayList<>(ans));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) { //left could be same as index value that is why we will only when we have processed the current indexes.
                        left++;  // avoid duplicity
                    }
                }

            }

        }

    }

}
