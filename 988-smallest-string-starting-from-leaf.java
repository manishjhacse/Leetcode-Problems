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

    static String ans;

    static void helper(TreeNode root, String curr){
        if(root==null) return;
        if(root.left==null && root.right==null){
            String x = ((char)(root.val+97)+"")+curr;
            if(ans.compareTo(x)>0) ans = x;
            return;
        }

        String x = (char)(root.val+97)+curr;
        helper(root.left,x);
        helper(root.right,x);
    }
    public String smallestFromLeaf(TreeNode root) {
        ans = "{";
        helper(root,"");
        return ans;
    }
}