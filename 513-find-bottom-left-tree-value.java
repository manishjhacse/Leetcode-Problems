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
    public int findBottomLeftValue(TreeNode root) {
        return leftMostValue(root, 0).root.val;
    }

    class DepthAndValue {
        int depth;
        TreeNode root;
        DepthAndValue() {}
        DepthAndValue(int depth, TreeNode root) {
            this.depth = depth;
            this.root = root;
        }
    }

    public DepthAndValue leftMostValue(TreeNode root, int depth){
        if(root.left == null && root.right == null) {
            return new DepthAndValue(depth, root);
        }

        if(root.left == null) {
            return leftMostValue(root.right, depth + 1);
        }
        if(root.right == null) {
            return leftMostValue(root.left, depth + 1);
        }

        DepthAndValue leftAns = leftMostValue(root.left, depth + 1);
        DepthAndValue rightAns = leftMostValue(root.right, depth + 1);
        if(leftAns.depth < rightAns.depth) return rightAns;
        else return leftAns;
    }
}