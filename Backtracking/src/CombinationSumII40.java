//40. Combination Sum II

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class CombinationSumII40 {

    List<List<Integer>> outputList;
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        this.target = target;
        this.candidates = candidates;
        outputList = new LinkedList<>();
        Arrays.sort(this.candidates); //sort because we have duplicate elements
        backTrack(0, new LinkedList<>(), 0);
        return outputList;
    }

    private void backTrack(int index, LinkedList<Integer> currList, int sum) {

        if (sum == target) {
            outputList.add(new LinkedList<>(currList));
            return;
        }

        if (sum > target) return;

        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && i != index && candidates[i - 1] == candidates[i]) continue; //if current is index is part of a running loop and is duplicate skip it
                                                                                        //only first encounter of any number can be taken which is i == index
            if (sum + candidates[i] > target) break; //as array is sorted and +ve numbers moving forward will always increase the sum

            currList.add(candidates[i]);
            backTrack(i + 1, currList, sum + candidates[i]);
            currList.removeLast();

        }
    }
}

//[2,5,2,1,2], target = 5
//[1, 2, 2, 2, 5]

//candidates = [10,1,2,7,6,1,5], target = 8
//[1,1,2,5,6,7,10]