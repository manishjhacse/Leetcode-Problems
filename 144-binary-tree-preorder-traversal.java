class Solution {
    public void preorderTraversalList(TreeNode root,List<Integer> list){
        if(root==null)
        return;
        list.add(root.val);
       preorderTraversalList(root.left,list); 
       preorderTraversalList(root.right,list); 
    } 
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
         preorderTraversalList(root,ans);
         return ans;
    }
}