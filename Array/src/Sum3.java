//15. 3Sum
//
//https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


class Main6 {
    public static void main(String args[]) {
        Sum3 sol = new Sum3();
        int[] arr = {-1, 0, 1, 2, -1, -4}; //[[-1,-1,2],[-1,0,1]] output
        int[] arr1 = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        int[] arr2 = {-1, -1, 2, 0};

        sol.threeSum(arr2).forEach(list -> {
            System.out.println(list);
        });

    }
}