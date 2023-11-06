class Solution {
    public int missingNumber(int[] nums) {
        // int res=0;
        // int n=nums.length;
        // int count[]=new int[n+1];
        // for(int i=0;i<nums.length;i++){
        //     count[nums[i]]++;
        // }
        // for(int i=0;i<count.length;i++){
        //     if(count[i]==0){
        //         res=i;
        //         break;
        //     }
        // }
        // return res;


            int xor=nums.length;
            for(int i=0;i<nums.length;i++){
                xor=xor^nums[i]^i;
            }
            return xor;

    }
}