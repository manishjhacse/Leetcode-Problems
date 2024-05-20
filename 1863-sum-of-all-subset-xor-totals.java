class Solution {
    public int xorSum(int []nums,int index,int xor){
        if(index==nums.length){
            return xor;
        }
        int indexPicked=xorSum(nums,index+1,xor^nums[index]);
        int indexNotPicked=xorSum(nums,index+1,xor);
        return indexPicked+indexNotPicked;
    }
    public int subsetXORSum(int[] nums) {
        return xorSum(nums,0,0);
    }
}