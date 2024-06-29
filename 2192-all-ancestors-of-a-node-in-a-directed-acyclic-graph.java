class Solution {
    private void dfs(List<List<Integer>> graph,int src,List<Integer> temp,boolean []vis){
        vis[src]=true;
        for(int i=0;i<graph.get(src).size();i++){
            if(!vis[graph.get(src).get(i)]){
            temp.add(graph.get(src).get(i));
            dfs(graph,graph.get(src).get(i),temp,vis);
            }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        List<List<Integer>> output=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> temp=new ArrayList<>();
            boolean vis[]=new boolean[n];
            dfs(graph,i,temp,vis);
            Collections.sort(temp);
            output.add(temp);
        }
        return output;
    }
}