package DS;

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
    //this problem can contain -ve numbers hence solve using map
    //if only +ve numbers then use variable sliding window if sum > i++
// -1, 1, 0, 7         map    0 -> 3
//                           -1 -> 1
//                            7 -> 1

//           7
//        0, 7
// -1, 1, 0, 7

    //		https://leetcode.com/problems/maximum-product-subarray/
    public class MaximumProductSubarray152 { //maximise the product - elements can be -ve
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
//add the previous sum if it is > 0

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
//had it been almost equal to target then use treemap use ceil/floor to find nearest diff

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
//if sum > target move left
//if sum <  target move right

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
//create right array, every index will have product of elements after that index

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
//Sort
//skip duplicate
//2 sum sorted
//skip duplicate


class MajorityElement169 {

    public int majorityElement(int[] nums) {

        return getMajority(nums, 0, nums.length - 1);

    }

    private int getMajority(int[] nums, int start, int end) {
        if (start == end)
            return nums[start];
        int mid = start + (end - start) / 2;

        int lElem = getMajority(nums, start, mid);
        int rElem = getMajority(nums, mid + 1, end);
        if (lElem == rElem)
            return rElem;

        int lCount = count(nums, start, mid, lElem);
        int rCount = count(nums, mid + 1, end, rElem);

        if (lCount > rCount)
            return lElem;

        return rElem;

    }

    private int count(int[] nums, int start, int end, int elem) {
        int counter = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == elem)
                counter++;
        }
        return counter;
    }
}
//there will be a majority element for sure
//min 2 elements
//merge sort types every level gives count of majority element nlogn