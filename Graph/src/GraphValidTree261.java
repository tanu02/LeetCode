//261. Graph Valid Tree
//
//https://leetcode.com/problems/graph-valid-tree/

import java.util.HashMap;
import java.util.Map;

class GraphValidTree261 {
    public boolean validTree(int n, int[][] edges) {
        int edgeCount = 0;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (!uf.union(from, to)) return false; //cycle
            edgeCount++;
        }

        return edgeCount == n - 1 ? true : false;
    }

    class UnionFind {
        //parent, rank
        Map<Integer, Integer> parent;
        Map<Integer, Integer> rank;

        public UnionFind(int n) {
            parent = new HashMap<>();
            rank = new HashMap<>();
            for (int i = 0; i < n; i++) {
                parent.put(i, i);
                rank.put(i, 1);
            }
        }

        public int find(int node) {
            int par = node;
            while (parent.get(par) != par) { //could be string in other questions
                par = parent.get(par);
            }
            parent.put(node, par);
            return par;
        }


        public boolean union(int from, int to) {
            int p1 = find(from);
            int p2 = find(to);

            if (p1 == p2) return false;  //cycle

            if (rank.get(p1) >= rank.get(p2)) {
                parent.put(p2, p1);
                rank.put(p1, rank.get(p2) + rank.get(p1));
            } else {
                parent.put(p1, p2);
                rank.put(p2, rank.get(p2) + rank.get(p1));
            }
            return true;
        }
    }
}

class Main11 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};//true
        GraphValidTree261 sol = new GraphValidTree261();
        System.out.println(sol.validTree(n, edges));

        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(sol.validTree(n1, edges1));//false
    }
}