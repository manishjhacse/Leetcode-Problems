/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int move = 0;

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftMove = dfs(root.left);
        int rightMove = dfs(root.right);
        root.val = leftMove + rightMove + (root.val - 1);
        move += Math.abs(root.val);
        return root.val;
    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }
}