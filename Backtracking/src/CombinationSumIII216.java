//216. Combination Sum III
//https://leetcode.com/problems/combination-sum-iii/

import java.util.LinkedList;
import java.util.List;

class CombinationSumIII216 {
    List<List<Integer>> outputList;
    int k;
    int target;
    int n = 9;

    public List<List<Integer>> combinationSum3(int k, int n) {

        this.target = n;
        this.k = k;
        outputList = new LinkedList<>();

        backTrack(1, new LinkedList<>(), 0);
        return outputList;

    }

    private void backTrack(int index, LinkedList<Integer> currList, int sum) {

        if (sum == target && currList.size() == k) {
            outputList.add(new LinkedList<>(currList));
            return;
        }

        if (sum > target || currList.size() > k) return;    //having current sum and moving further will always increase the total sum

        for (int i = index; i <= n; i++) {

            currList.add(i);
            backTrack(i + 1, currList, sum + i);
            currList.removeLast();
        }
    }
}

//Input: k = 3, n = 7
//Input: k = 9, n = 45