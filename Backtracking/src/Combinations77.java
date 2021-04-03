import java.util.LinkedList;
import java.util.List;
//https://leetcode.com/problems/combinations/

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