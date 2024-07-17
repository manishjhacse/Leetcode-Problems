import java.util.HashSet;

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
    private TreeNode deleteNodes(TreeNode root, HashSet<Integer> to_delete, List<TreeNode> forest) {
        if (root == null) {
            return null;
        }
        root.left = deleteNodes(root.left, to_delete, forest);
        root.right = deleteNodes(root.right, to_delete, forest);
        if (to_delete.contains(root.val)) {
            if (root.left != null) {
                forest.add(root.left);
            }
            if (root.right != null) {
                forest.add(root.right);
            }
            root.left = null;
            root.right = null;
            return null;
        }
        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> delete = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            delete.add(to_delete[i]);
        }
        List<TreeNode> forest = new ArrayList<>();
        root = deleteNodes(root, delete, forest);
        if (root!=null) {
            forest.add(root);
        }
        return forest;
    }
}