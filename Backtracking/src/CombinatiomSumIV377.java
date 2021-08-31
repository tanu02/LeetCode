//377. Combination Sum IV
//https://leetcode.com/problems/combination-sum-iv/

import java.util.LinkedList;

class CombinatiomSumIV377 {
    int count;
    int[] nums;
    int target;

    public int combinationSum4(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        backTrack(new LinkedList<>(), 0);
        return count;
    }

    private void backTrack(LinkedList<Integer> currList, int sum) {

        if (sum == target) {
            count++;
            return;
        }
        if (sum > target) return;

        for (int i = 0; i < nums.length; i++) {
            currList.add(nums[i]);
            backTrack(currList, sum + nums[i]);
            currList.removeLast();
        }

    }
}