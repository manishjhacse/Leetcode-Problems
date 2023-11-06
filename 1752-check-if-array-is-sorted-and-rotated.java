class Solution {
    public boolean check(int[] nums) {
        int flag=0;
        int pIndex=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                flag++;
                pIndex=i-1;
            }
            if(nums[i-1]>nums[i] && flag>1){
                return false;
            }

        }
        if(pIndex!=-1 && (nums[pIndex]<nums[nums.length-1] ||nums[0]<nums[nums.length-1]))
        return false;
        else
        return true;
       
    }
}