//323. Number of Connected Components in an Undirected Graph
//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/


import java.util.*;

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


class Main6 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};

        int n2 = 4;
        int[][] edges2 = {{2, 3}, {1, 2}, {1, 3}};
        NumberofConnectedComponentsUndirectedGraph323 sol = new NumberofConnectedComponentsUndirectedGraph323();
        System.out.println(sol.countComponents(n, edges));
        System.out.println(sol.countComponents(n1, edges1));
        System.out.println(sol.countComponents(n2, edges2));
    }
}


