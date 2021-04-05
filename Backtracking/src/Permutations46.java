import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
//46. Permutations


//https://leetcode.com/problems/permutations/

class Permutations46 {

    List<List<Integer>> outputList;

    public List<List<Integer>> permute(int[] nums) {

        outputList = new ArrayList<>();  //
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        //box primitive integer to Integer object
        backTrack(0, list); //in permutation q we don't need doubly ll as we are just swapping values and not removing any links unlike combination where we appended in empty list
        return outputList;

    }

    private void backTrack(int index, List<Integer> currList) { //index wise state - as many elements after that index that many swaps in that state

        if (index == currList.size()) outputList.add(new ArrayList<>(currList));

        for (int i = index; i < currList.size(); i++) {
            Collections.swap(currList, index, i);
            backTrack(index + 1, currList);
            Collections.swap(currList, index, i);
        }
    }
}
//permutation is just swapping existing elements(use arraylist) - input is list of elements unlike combination where input was an empty list

//1, 2, 3

//        1 2 3               2 1 3              3 2 1
//    1 2 3    1 3 2      2 1 3   2 3 1      3 2 1    3 1 2
//    1 2 3    1 3 2      2 1 3   2 3 1      3 2 1    3 1 2
//      x        x          x       x          x        x         [index == size]

