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
    public void chan(TreeNode root, int ind, List<Integer> sum){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        if(root.left==null) root.right.val=sum.get(ind)-root.right.val;
        else if(root.right==null) root.left.val=sum.get(ind)-root.left.val;
        else{
            int tot= sum.get(ind);
            int lv= root.left.val;
            int rv= root.right.val;
            root.left.val= tot-rv-lv;
            root.right.val= tot-rv-lv;
        }
        chan(root.left, ind+1, sum);
        chan(root.right, ind+1, sum);
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> sums= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s= q.size();
            int c=0;
            for(int i=0; i<s; i++){
                TreeNode cur= q.poll();
                c+=cur.val;
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            sums.add(c);
        }
        chan(root, 1, sums);
        root.val=0;
        return root;
    }
}