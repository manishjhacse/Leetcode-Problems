class Solution {
    public int longestSubarray(int[] nums) {
        int maxElement = nums[0];
        int maxLen = 0;
        int len = 0;
        for (int num : nums) {
            if (num > maxElement) {
                maxElement = num;
                len = 0;
                maxLen = 0;
            }
            if (num == maxElement) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 0;
            }
        }
        return maxLen;
    }
}