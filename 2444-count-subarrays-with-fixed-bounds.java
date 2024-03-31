class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIndex = -1;
        int maxIndex = -1;
        int invalidPlace = -1;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) {
                minIndex = i;
            }
            if (nums[i] == maxK) {
                maxIndex = i;
            }
            if (nums[i] < minK || nums[i] > maxK) {
                invalidPlace = i;
            }
            if (minIndex != -1 && maxIndex != -1) {
                int start = Math.min(minIndex, maxIndex);
                if (start - invalidPlace > 0) {
                    ans += (start - invalidPlace);
                }
            }
        }
        return ans;
    }
}