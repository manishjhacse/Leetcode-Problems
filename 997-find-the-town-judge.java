class Solution {
    public int findJudge(int n, int[][] trust) {
        int []degree=new int[n+1];
        for(int [] arr:trust){
            degree[arr[0]]--;
            degree[arr[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(degree[i]==n-1)
            return i;
        }
        return -1;
    }
}