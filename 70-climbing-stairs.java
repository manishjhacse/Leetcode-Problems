class Solution {
    public int ways(int i,int n,int []dp){
        if(i==n)
        return 1;
        if(i>n)
        return 0;
        if(dp[i]!=-1)
        return dp[i];
        dp[i]=ways(i+1, n, dp)+ways(i+2, n, dp);
        return dp[i];
    }
    public int climbStairs(int n) {
       int []dp=new int[n+1];
       Arrays.fill(dp,-1);
       return ways(0,n,dp);
    }
}