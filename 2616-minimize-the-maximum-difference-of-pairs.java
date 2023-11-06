import java.util.Arrays;

class Solution {
    boolean check(int nums[],int mid,int n,int p)
    {
        int in=0;
        int cnt=0;
        for(int i=1;i<n;i++)
        {
            if(in!=0)
            {
                in=0;
                continue;
            }
            if(nums[i]-nums[i-1]<=mid)
            {
                in=1;
                cnt++;
            }
        }
        return cnt>=p;
    }
    public int minimizeMax(int[] nums, int p) {
        int n=nums.length;
        Arrays.sort(nums);
        int low=0,high=nums[n-1];
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(check(nums,mid,n,p)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}