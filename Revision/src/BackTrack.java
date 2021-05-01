import java.util.LinkedList;
import java.util.*;
import java.util.stream.Collectors;

public class BackTrack {
}

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

            if (uniqueEntries.contains(currList.get(i)))
                continue; //every state should only process unique entries
            //as length is same after swap eventually same permutation will be generated
            uniqueEntries.add(currList.get(i));
            Collections.swap(currList, index, i);
            backTrack(index + 1, currList); //every state has a index which will be swapped with remaining elements
            Collections.swap(currList, index, i);
        }
    }
}


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

        if (sum > target || currList.size() > k)
            return;    //having current sum and moving further will always increase the total sum

        for (int i = index; i <= n; i++) {

            currList.add(i);
            backTrack(i + 1, currList, sum + i);
            currList.removeLast();
        }
    }
}

//Input: k = 3, n = 7
//Input: k = 9, n = 45

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
//combination gets an empty list as input and we are removing elements so use Linkedlist

// [1, 2, 3], target = 5
//  1                   / 50% is not calculated unlike permutation where every state had equal mumber of items in the list
//  1, 2              /
//  1, 2, 3         /
//  1, 3          /
//              /
//  2         /
//  2,3     /
//        /
//  3   /

class Combinations77 {
    List<List<Integer>> outputList;
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        outputList = new LinkedList<>();
        backTrack(1, new LinkedList<>());//better for manipulation unlike arraylist
        return outputList;
    }

    private void backTrack(int index, LinkedList<Integer> currList) { //doubly ll
        if (currList.size() == k) {
            outputList.add(new LinkedList<>(currList));
            return;
        }

        for (int i = index; i <= n; i++) {
            currList.add(i);
            backTrack(i + 1, currList);
            currList.removeLast();
        }

    }
}


class WordSearch1 {
    char[][] board;
    int row, col;
    String word;

    int[] rows = {0, 0, -1, 1};
    int[] cols = {1, -1, 0, 0};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        this.word = word;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (index == this.word.length()) return true; //word length

        if (i < 0 || i == row || j < 0 || j == col || board[i][j] != word.charAt(index) || board[i][j] == 1)
            return false; //exceeded boundary looking for next char means word length not reached

        board[i][j] = '1'; //visit

        for (int d = 0; d < rows.length; d++) { //explore neighbors
            if (dfs(i + rows[d], j + cols[d], index + 1)) return true; //if any direction has the answer
        }

        board[i][j] = word.charAt(index); //unvisit
        return false;
    }
}
//O(N*3^L)