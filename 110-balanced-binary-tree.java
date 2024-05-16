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
    public int check(TreeNode root) {
        if(root==null)
        return 0;
        int LeftHeight=check(root.left);
        if(LeftHeight==-1)
        return -1;
        int RightHeight=check(root.right);
        if(RightHeight==-1)
        return -1;
        if(Math.abs(LeftHeight-RightHeight)>1)
        return -1;
        return 1+Math.max(LeftHeight,RightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }
}