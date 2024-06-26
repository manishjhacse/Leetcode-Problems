import java.util.ArrayList;

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
    public void inorder(TreeNode root, ArrayList<Integer> List) {
        if (root == null) {
            return;
        }
        inorder(root.left, List);
        List.add(root.val);
        inorder(root.right, List);
    }

    public TreeNode balanceTree(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = balanceTree(list, start, mid - 1);
        root.right = balanceTree(list, mid + 1, end);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorderedList = new ArrayList<>();
        inorder(root, inorderedList);
        return balanceTree(inorderedList,0,inorderedList.size()-1);
    }
}