/*
100. Same Tree
https://leetcode.com/problems/same-tree/

*/

class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkSameTree(p, q);
    }

    private boolean checkSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return checkSameTree(p.left, q.left) && checkSameTree(p.right, q.right);

    }

}

class Main11{
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode oneC = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode twoC = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode threeC = new TreeNode(3);

        one.left = two;
        one.right = three;

        oneC.left = twoC;
        oneC.right = threeC;

        SameTree100 sol = new SameTree100();
        System.out.println(sol.isSameTree(one, oneC));
    }
}
