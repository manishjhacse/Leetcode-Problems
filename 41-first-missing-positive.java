class Solution {
    public int firstMissingPositive(int[] nums) {
    int n=nums.length;
    for(int i=0;i<n;i++){
        if(nums[i]<=0 || nums[i]>=n+1)
        nums[i]=n+1;
    }
    for(int i=0;i<n;i++){
      int element=Math.abs(nums[i]);
      if(element!=n+1){
        if(nums[element-1]>0){
            nums[element-1]=nums[element-1]*-1;
        }
      }
    }
    
    for(int i=0;i<n;i++){
        if(nums[i]>0){
            return i+1;
        }
    }
    return n+1;
    }
}