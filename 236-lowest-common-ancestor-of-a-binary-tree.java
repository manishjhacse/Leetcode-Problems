/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftCheck = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCheck = lowestCommonAncestor(root.right, p, q);
        if (leftCheck != null && rightCheck != null) {
            return root;
        }
        if (leftCheck != null) {
            return leftCheck;
        } else {
            return rightCheck;
        }
    }
}