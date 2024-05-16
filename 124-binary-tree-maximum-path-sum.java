/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max=Integer.MIN_VALUE;
    public int check(TreeNode root){
        if(root==null)
        return 0;
        int leftVal=check(root.left);
        int rightVal=check(root.right);
        // int leftVal=Math.max(0,check(root.left));
        // int rightVal=Math.max(0,check(root.right));
        int tempMax=Math.max(Math.max(leftVal,rightVal)+root.val,root.val);
        int sum=root.val+leftVal+rightVal;
        max=Math.max(max,Math.max(sum,tempMax));
        return tempMax;
    }
    public int maxPathSum(TreeNode root) {
      check(root);
      return max;
    }
}