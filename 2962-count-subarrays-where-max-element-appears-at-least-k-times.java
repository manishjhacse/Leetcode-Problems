class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxNum = Math.max(nums[i], maxNum);
        }
        int start = 0, end = 0;
        int freqCount = 0;
        long ans = 0;
        while (end < nums.length) {
            if (nums[end] == maxNum) {
                freqCount++;
            }

            while (freqCount == k) {
                ans = ans + (nums.length - end);
                if (nums[start] == maxNum) {
                    freqCount--;
                }
                start++;
            }
            end++;
        }
        return ans;

    }
}