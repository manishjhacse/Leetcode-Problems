import java.util.List;

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
    // public void postorderTraversalList(TreeNode root,List<Integer> list){
    // if(root==null)
    // return;
    // postorderTraversalList(root.left,list);
    // postorderTraversalList(root.right,list);
    // list.add(root.val);
    // }
    // public List<Integer> postorderTraversal(TreeNode root) {
    // List<Integer> ans=new ArrayList<>();
    // postorderTraversalList(root,ans);
    // return ans;
    // }
    public List<Integer> returnPostorderList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        list.addAll(returnPostorderList(root.left));
        list.addAll(returnPostorderList(root.right));
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        return returnPostorderList(root);
    }
}