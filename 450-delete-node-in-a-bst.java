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
    TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode curr = root;
        while (curr != null && curr.val != key) {
            parent = curr;
            if (key < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }
        // key not present in Tree
        if (curr == null) {
            return root;
        }
        // leaf node is to be deleted
        if (curr.left == null && curr.right == null) {
            if (curr == root) {
                return null;
            }
            if (parent.left == curr) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // node with one child is to be deleted
        else if (curr.left == null || curr.right == null) {
            TreeNode child;
            if (curr.left != null) {
                child = curr.left;
            } else {
                child = curr.right;
            }
            if (curr == root) {
                return child;
            }
            if (parent.left == curr) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        // node with two children is to be deleted
        else {
            TreeNode rightMin = getMin(curr.right);
            int minVal = rightMin.val;
            deleteNode(curr, minVal);
            curr.val = minVal;
        }
        return root;
    }
}