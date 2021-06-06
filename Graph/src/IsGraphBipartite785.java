//785. Is Graph Bipartite?
//https://leetcode.com/problems/is-graph-bipartite/

import java.util.HashMap;
import java.util.Map;

//can be a disconnected graph
class IsGraphBipartite785 {
    Map<Integer, int[]> adjMap;
    Map<Integer, Integer> colorMap;

    public boolean isBipartite(int[][] graph) {

        if (graph == null || graph.length == 0) return true;
        adjMap = new HashMap<>();
        colorMap = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            adjMap.put(i, graph[i]);
        }
        for(int i = 0; i < graph.length; i++) {   // 0 - 2   1 -  3 [disconnected but bipartite]
             if(!colorMap.containsKey(i) && !dfs(i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(int node, int color) {

        if (colorMap.containsKey(node))
            return colorMap.get(node) == color;     //already colored, if same color true else false

        colorMap.put(node, color);

        for (int next : adjMap.get(node)) {
            if (!dfs(next, -color)) return false;
        }

        return true;
    }
}

//this dfs looks validation from each adj node ( child node) so loop will have false and method completion will have true
//if visited return /do action -> visit -> visit edges -> take final action

class Main99 {
    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        IsGraphBipartite785 sol = new IsGraphBipartite785();
        int[][] graph2 = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        int[][] graph3 = {{},{1,1}};
        int[][] graph4 = {{2},{3},{0},{1}}; //disconnected
        int[][] graph5 =  {{1}, {1}};
        System.out.println(sol.isBipartite(graph));//true
        System.out.println(sol.isBipartite(graph1));//false
        System.out.println(sol.isBipartite(graph2));//false
        System.out.println(sol.isBipartite(graph3));//false
        System.out.println(sol.isBipartite(graph4));//true
        System.out.println(sol.isBipartite(graph5));

    }
}
