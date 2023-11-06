class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l=0,h=nums.length-1;
        while(l<h){
            if(( nums[ l ] & 0x1 ) == 0){
                l++;
            }
            else if(( nums[ h ] & 0x1 ) != 0){
                h--;
            }
            else{
                int temp=nums[l];
                nums[l]=nums[h];
                nums[h]=temp;
                l++;
                h--;
            }
        }
        return nums;
    }
}