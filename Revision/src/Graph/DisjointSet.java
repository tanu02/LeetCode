package Graph;

import java.util.*;

public class DisjointSet {
}

//128. Longest Consecutive Sequence
//https://leetcode.com/problems/longest-consecutive-sequence/

class LongestConsecutive1Sequence128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int node :  nums){
            set.add(node);
        }
        UnionFind uf = new UnionFind(nums);

        for (Integer node : set) {

            if (set.contains(node + 1))
                uf.union(node, node + 1);

        }
        return uf.getMaxLength();
    }

    class UnionFind {
        //parent, rank
        Map<Integer, Integer> parent;
        Map<Integer, Integer> rank;

        public int getMaxLength() {
            int maxLength = 0;
            for (int par : rank.keySet()) {
                if (parent.get(par) == par) {
                    maxLength = Math.max(maxLength, rank.get(par));
                }
            }
            return maxLength;
        }


        public UnionFind(int[] nums) {
            parent = new HashMap<>();
            rank = new HashMap<>();
            for (int num : nums) {
                parent.put(num, num);
                rank.put(num, 1);
            }
        }

        public int find(int node) {
            int par = node;
            while (parent.get(par) != par) {
                par = parent.get(par);

            }
            parent.put(node, par);
            return par;
        }

        public void union(int from, int to) {

            int p1 = find(from);
            int p2 = find(to);

            if (p1 == p2) return;

            if (rank.get(p1) >= rank.get(p2)) {
                parent.put(p2, p1);
                rank.put(p1, rank.get(p1) + rank.get(p2));
            } else {
                parent.put(p1, p2);
                rank.put(p2, rank.get(p1) + rank.get(p2));
            }
        }
    }
}

//261. Graph.Graph Valid Tree
//https://leetcode.com/problems/graph-valid-tree/
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

        return edgeCount == n - 1;
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

//try using heap when on run time you are inserting something
//kruskal knows everything will go in an order i.e smallest to largest so just sort it we are not pushing anything on runtime unlike prims/Djkta why create a separate ds and pushing everything inside it
//
//1135. Connecting Cities With Minimum Cost
//https://leetcode.com/problems/connecting-cities-with-minimum-cost/

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


//399. Evaluate Division
//https://leetcode.com/problems/evaluate-division/
class EvaluateDivision399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        UnionFind uf = new UnionFind(equations);
        for (int j = 0; j < equations.size(); j++) {
            List<String> equation = equations.get(j);
            uf.union(equation.get(0), equation.get(1), values[j]);
        }

        double[] output = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);

            output[i] = uf.query(from, to);
        }
        return output;
    }

    class UnionFind {
        //parent, distance
        Map<String, String> parent;
        Map<String, Double> distance;

        public UnionFind(List<List<String>> equations) {
//parent - self, distance 1
            parent = new HashMap<>();
            distance = new HashMap<>();
            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);

                String from = equation.get(0);
                String to = equation.get(1);

                parent.put(from, from);
                parent.put(to, to);
                distance.put(from, 1.0);
                distance.put(to, 1.0);
            }

        }

        public String find(String node) {
            String par = node;
            double product = distance.get(node);

            while (!parent.get(par).equals(par)) {
                par = parent.get(par);
                product *= distance.get(par);
            }
            parent.put(node, par);
            distance.put(node, product);
            return par;

        }

        public void union(String from, String to, double dst) {

            String p1 = find(from);
            String p2 = find(to);

            if (p1.equals(p2)) return;

            parent.put(p1, p2); //joining 2 diff parents
            double parentDis = dst * distance.get(to) / distance.get(from);
            distance.put(p1, parentDis);
        }

//from -> x    y <- to
//from -> x -- y <- to
// from/x x/y y/to = dst

//dst(from) * ans * 1/dst(to) = dst
//ans = dst * dst(to)/dst(from)

        public double query(String from, String to) {
            if (!parent.containsKey(from) || !parent.containsKey(to)) return -1;

            String p1 = find(from);
            String p2 = find(to);

            if (!p1.equals(p2)) return -1.0;

            return distance.get(from) / distance.get(to);
        }
    }
}
