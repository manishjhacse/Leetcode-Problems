class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int k=0,ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=1){
                k=0;
            }else{
                k=k+1;
                ans=Math.max(ans,k);
            }
        }
        return  ans;
    }
}