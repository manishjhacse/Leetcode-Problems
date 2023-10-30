class Solution 
{
    public int[] getConcatenation(int[] nums) 
    {
        int n;
        n=nums.length;
        int ans[]=new int[n+n];
        for(int i=0;i<n;i++){
            ans[i]=ans[i+n]=nums[i];
        }
        return ans;
    }
}