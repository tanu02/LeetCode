import java.util.*;

public class Graph {
}

class NumberofConnectedComponentsUndirectedGraph323 {
    public int countComponents(int n, int[][] edges) {
        if (n <= 0 || edges == null || edges.length == 0 || edges[0].length == 0) return n;

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] edge : edges) { // 0 - 1
            List<Integer> list1 = adjMap.getOrDefault(edge[0], new ArrayList<>());
            list1.add(edge[1]);
            adjMap.put(edge[0], list1);

            List<Integer> list2 = adjMap.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            adjMap.put(edge[1], list2);

        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, visited, adjMap);
                count++;
            }
        }
        return count;
    }


    private void dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> adjMap) {
        if (visited.contains(node)) return;

        visited.add(node);
        if (adjMap.containsKey(node)) {
            for (Integer next : adjMap.get(node)) {
                dfs(next, visited, adjMap);
            }
        }
    }
}
//adjMap non directed
//dfs on keyset
//dfs on connected nodes

//visited then return
//visit
//dfs neighbours
//there can be 5 nodes  and 1 edge hence loop  through  the nodes and not keyset


//https://leetcode.com/problems/longest-consecutive-sequence/
class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int elem : nums) {
            set.add(elem);

        }
        int maxLength = 0;
        for (int num : nums) {

            int count = 0;
            int currElem = num;

            if (!set.contains(currElem - 1)) {  // 3 2 1 4 -> skip 3, skip 2
                while (set.contains(currElem)) { //  start from 1 till 4	-> 1 2 3 4
                    count++;
                    currElem++;
                }

            }

            maxLength = Math.max(maxLength, count);

        }
        return maxLength;
    }
}
//out of given numbers find how many consecutive numbers are there out of which find the max length

//create a set of all the elements
//if arr[I] is the smallest element count the sequence[set does not contain smaller element than arr[I]]
//return max length