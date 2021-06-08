//167. Two Sum II - Input array is sorted
//
//        https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

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