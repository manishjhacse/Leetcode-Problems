class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans=0;
        int product=1;
        int start=0,end=0;
        while (end<nums.length) {
            product*=nums[end];
            while (product>=k && start<=end) {
                product/=nums[start++];
            }
            ans+=(end-start+1);
            end++;
        }
        return ans;
    }
}