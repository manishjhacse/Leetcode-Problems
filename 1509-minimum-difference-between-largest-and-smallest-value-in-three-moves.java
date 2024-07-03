import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        res = Math.min(res, nums[n - 4] - nums[0]);
        res = Math.min(res, nums[n - 3] - nums[0 + 1]);
        res = Math.min(res, nums[n - 2] - nums[0 + 2]);
        res = Math.min(res, nums[n - 1] - nums[0 + 3]);
        return res;
    }
}