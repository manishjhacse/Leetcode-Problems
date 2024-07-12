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
    int count = 0;
    int ans;

    void inorderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, k);
        count++;
        if(count==k){
            ans=k;
            return;
        }
        inorderTraversal(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return ans;
    }
}