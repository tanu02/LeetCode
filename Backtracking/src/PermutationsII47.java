//47. Permutations II
//https://leetcode.com/problems/permutations-ii/

//duplicates can be there

import java.util.*;
import java.util.stream.Collectors;

class PermutationsII47 {

    List<List<Integer>> outputList;

    public List<List<Integer>> permuteUnique(int[] nums) {
        outputList = new ArrayList<>();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        backTrack(0, list);
        return outputList;
    }

    private void backTrack(int index, List<Integer> currList) {

        if (index == currList.size()) outputList.add(new ArrayList<>(currList));
        Set<Integer> uniqueEntries = new HashSet<>();
        for (int i = index; i < currList.size(); i++) {

            if(uniqueEntries.contains(currList.get(i)))
                continue; //every state should only process unique entries
                            //as length is same after swap eventually same permutation will be generated
            uniqueEntries.add(currList.get(i));
            Collections.swap(currList, index, i);
            backTrack(index + 1, currList); //every state has a index which will be swapped with remaining elements
            Collections.swap(currList, index, i);
        }
    }
}
