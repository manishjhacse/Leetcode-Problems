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
    public void findLeaves(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            list.add(root.val);
        findLeaves(root.left, list);
        findLeaves(root.right, list);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        findLeaves(root1, tree1);
        findLeaves(root2, tree2);
        if (tree1.size() != tree2.size())
            return false;
        for (int i = 0; i < tree1.size(); i++) {
            if (tree1.get(i) != tree2.get(i))
                return false;
        }
        return true;
    }
}