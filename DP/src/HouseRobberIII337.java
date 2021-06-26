/*
337. House Robber III
https://leetcode.com/problems/house-robber-iii/

*/

import java.util.HashMap;
import java.util.Map;

class HouseRobberIII337 {
    Map<TreeNode, Integer> taken;
    Map<TreeNode, Integer> notTaken;

    public int rob(TreeNode root) { //law of. Demeter you can’t access. Grandchildren
        if (root == null) return 0;  //way to access them is child node.  Will return.

        taken = new HashMap<>();
        notTaken = new HashMap<>();

        return dp(root, 0);
    }

    private int dp(TreeNode node, int prev) {

        if (node == null) return 0;

        if (prev == 1) {
            if (notTaken.containsKey(node)) return notTaken.get(node);

            int notRob = dp(node.left, 0) + dp(node.right, 0);
            notTaken.put(node, notRob);
            return notTaken.get(node);
        } else {
            if (taken.containsKey(node)) return taken.get(node);

            int rob = node.val + dp(node.left, 1) + dp(node.right, 1);
            int notRob = dp(node.left, 0) + dp(node.right, 0);
            int ans =  Math.max(rob, notRob);
            taken.put(node, ans);
            return taken.get(node);
        }

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main22 {
    public static void main(String[] args) {
        HouseRobberIII337 sol = new HouseRobberIII337();

        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode three1 = new TreeNode(3);

        TreeNode three2 = new TreeNode(3);
        TreeNode one = new TreeNode(1);

        three.left = two;
        three.right = three1;

        two.right = three2;
        three1.right = one;
        System.out.println(sol.rob(three));//7
    }
}
