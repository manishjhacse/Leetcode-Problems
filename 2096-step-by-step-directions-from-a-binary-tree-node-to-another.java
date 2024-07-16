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
    boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.left != null) {
            path.append("L");
            if (findPath(root.left, target, path)) {
                return true;
            }
            path.setLength(path.length() - 1);
        }
        if (root.right != null) {

            path.append("R");
            if (findPath(root.right, target, path)) {
                return true;
            }
            path.setLength(path.length() - 1);
        }
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStartValue = new StringBuilder();
        StringBuilder pathToDestValue = new StringBuilder();
        StringBuilder res = new StringBuilder();
        findPath(root, startValue, pathToStartValue);
        findPath(root, destValue, pathToDestValue);
        int s = 0, d = 0;
        while (s < pathToStartValue.length() && d < pathToDestValue.length()) {
            if (pathToStartValue.charAt(s) == pathToDestValue.charAt(d)) {
                s++;
                d++;
            } else {
                break;
            }
        }

        for (int i = s; i < pathToStartValue.length(); i++) {
            res.append("U");
        }
        for (int i = d; i < pathToDestValue.length(); i++) {
            res.append(pathToDestValue.charAt(i));
        }
        return res.toString();
    }
}