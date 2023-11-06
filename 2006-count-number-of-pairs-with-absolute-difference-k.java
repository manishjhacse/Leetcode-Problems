import java.util.HashMap;

class Solution {
    public int countKDifference(int[] nums, int k) {
        int res=0;
       int count[]=new int[101];
       for(int i=0;i<nums.length;i++)
       {
        count[nums[i]]++;
       }
       for(int i=k+1;i<count.length;i++)
       {
        res+=count[i]*count[i-k];
       }
       return res;
    }
}