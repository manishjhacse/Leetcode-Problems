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
    int ans = 0;

    public int[] leafDist(TreeNode root, int distance) {
        int leafDist[] = new int[11];
        if (root == null) {
            return leafDist;
        }
        if (root.left == null && root.right == null) {
            leafDist[1] = 1;
            return leafDist;
        }
        int left[] = leafDist(root.left, distance);
        int right[] = leafDist(root.right, distance);
        for (int i = 1; i < distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    ans += left[i] * right[j];
                }
            }
        }
        for (int i = 1; i < 11; i++) {
            leafDist[i] = left[i - 1] + right[i - 1];
        }
        return leafDist;

    }

    public int countPairs(TreeNode root, int distance) {
        leafDist(root, distance);
        return ans;
    }
}