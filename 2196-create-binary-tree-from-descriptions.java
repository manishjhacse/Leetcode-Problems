import java.util.HashMap;
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> tree = new HashMap<>();
        HashSet<Integer> childs = new HashSet<>();
        for (int[] d : descriptions) {
            if (!tree.containsKey(d[0])) {
                tree.put(d[0], new TreeNode(d[0]));
            }
            if (!tree.containsKey(d[1])) {
                tree.put(d[1], new TreeNode(d[1]));
            }
            if (d[2] == 1) {
                tree.get(d[0]).left = tree.get(d[1]);
            } else {
                tree.get(d[0]).right = tree.get(d[1]);

            }
            childs.add(d[1]);
        }
        for (int[] d : descriptions) {
            if (!childs.contains(d[0])) {
                return tree.get(d[0]);
            }
        }
        return null;
    }
}