import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
class CombinationSum39 {

    List<List<Integer>> outputList;
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.target = target;
        this.candidates = candidates;
        outputList = new LinkedList<>();

        backTrack(0, new LinkedList<>(), 0);
        return outputList;
    }

    private void backTrack(int index, LinkedList<Integer> currList, int sum) { //ensure if list is passed as new ... then accespt it in same data type and not List

        if (sum == target) outputList.add(new LinkedList<>(currList));
        if (sum > target) return;

        for (int i = index; i < candidates.length; i++) {

            currList.add(candidates[i]);
            backTrack(i, currList, sum + candidates[i]);
            currList.removeLast();

        }
    }
}
// [2,3,6,7], target = 7

