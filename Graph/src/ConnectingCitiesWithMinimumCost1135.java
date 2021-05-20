//try using heap when on run time you are inserting something 
//kruskal knows everything will go in an order i.e smallest to largest so just sort it we are not pushing anything on runtime unlike prims/Djkta why create a separate ds and pushing everything inside it
//
//1135. Connecting Cities With Minimum Cost
//https://leetcode.com/problems/connecting-cities-with-minimum-cost/


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ConnectingCitiesWithMinimumCost1135 {

    public int minimumCost(int n, int[][] connections) { //edges from 1 -> n

        UnionFind uf = new UnionFind(n);
        int count = 0, totalWeight = 0;
        Arrays.sort(connections, (edge1, edge2) -> Integer.compare(edge1[2], edge2[2]));

        for (int[] connection : connections) {

            int from = connection[0];
            int to = connection[1];
            int weight = connection[2];

            if (uf.union(from, to)) {
                totalWeight += weight;
                count++;
            }
        }
        return count == n - 1 ? totalWeight : -1;
    }

    class UnionFind {
//parent, rank
        Map<Integer, Integer> parent;
        Map<Integer, Integer> rank;

        public UnionFind(int n) {
            parent = new HashMap<>();
            rank = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                parent.put(i, i);
                rank.put(i, 1);
            }
        }

        public boolean union(int from, int to) {
            int p1 = find(from);
            int p2 = find(to);

            if (p1 == p2) return false;

            if (rank.get(p1) >= rank.get(p2)) {
                parent.put(p2, p1);
                rank.put(p1, rank.get(p1) + rank.get(p2));
            } else {
                parent.put(p1, p2);
                rank.put(p2, rank.get(p1) + rank.get(p2));
            }
            return true;
        }

        public int find(int node) {
            int par = node;
            while (parent.get(par) != par) {
                par = parent.get(par);

            }
            parent.put(node, par);
            return par;
        }

    }//O(N) COMPLEXITY N IS NUMBER OF EDGES

}


class Main8 {
    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};

        int n1 = 4;
        int[][] connections1 = {{1, 2, 3}, {3, 4, 4}};

        ConnectingCitiesWithMinimumCost1135 sol = new ConnectingCitiesWithMinimumCost1135();
        System.out.println(sol.minimumCost(n, connections));//6
        System.out.println(sol.minimumCost(n1, connections1));//-1

    }
}
