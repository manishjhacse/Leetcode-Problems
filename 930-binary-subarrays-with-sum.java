class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) 
    {
        return SUMARRAY(nums,goal)-SUMARRAY(nums,goal-1);
    }
    public int SUMARRAY(int nums[],int goal)
    {
        if(goal<0)
        return 0;
        int count=0,i=0,j=0,sum=0;
        while(i<nums.length) 
        {
            sum+=nums[i]; 
            while(j<nums.length&&sum>goal)
            {
                sum-=nums[j];
                j++;
            }
            count+=i-j+1;
            i++;
        }
        return count;
    }
}