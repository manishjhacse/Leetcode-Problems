class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int l = 0, h = nums.length - 1;
        int minNumber = Integer.MAX_VALUE;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if(nums[l]<=nums[mid]){
                minNumber=Math.min(minNumber,nums[l]);
                l=mid+1;
            }else{
                minNumber=Math.min(minNumber,nums[mid]);
                h=mid-1;
            }
            
        }
        return minNumber;
    }
}