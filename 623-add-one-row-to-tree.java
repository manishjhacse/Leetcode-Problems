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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        addOneRowDFS(root, 1, depth, val);
        return root;
    }

    public void addOneRowDFS(TreeNode root, int currentDepth, int depth, int val) {
        if (root == null)
            return;

        if (currentDepth == depth - 1) {
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = root.left;
            root.left = newLeft;
            TreeNode newRight = new TreeNode(val);
            newRight.right = root.right;
            root.right = newRight;
            return;
        }
        addOneRowDFS(root.left, currentDepth + 1, depth, val);
        addOneRowDFS(root.right, currentDepth + 1, depth, val);
        return;

    }
}