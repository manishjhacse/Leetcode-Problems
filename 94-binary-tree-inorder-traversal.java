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
    public void inorderTraversalList(TreeNode root,List<Integer> list){
        if(root==null)
        return;
        inorderTraversalList(root.left,list); 
        list.add(root.val);
        inorderTraversalList(root.right,list); 
    } 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        inorderTraversalList(root,ans);
         return ans;
    }
}
