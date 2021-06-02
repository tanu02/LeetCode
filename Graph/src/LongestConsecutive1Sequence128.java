//128. Longest Consecutive Sequence
//
//https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    class Main66 {
        public static void main(String[] args) {
            LongestConsecutive1Sequence128 sol = new LongestConsecutive1Sequence128();
            int[] nums = {100, 4, 200, 1, 3, 2};
            System.out.println(sol.longestConsecutive(nums));

            int[] nums1 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
            System.out.println(sol.longestConsecutive(nums1));

        }
    }