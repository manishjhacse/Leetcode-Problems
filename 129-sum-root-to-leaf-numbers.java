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
    int sum = 0;

    public void getAllSum(TreeNode root, int value) {
        if (root == null) {
            return;
        }
        value = value * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += value;
            return;
        }
        getAllSum(root.left, value);
        getAllSum(root.right, value);
    }

    public int sumNumbers(TreeNode root) {
        getAllSum(root, 0);
        return sum;
    }
}