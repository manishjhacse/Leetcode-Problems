class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // creating array to store max at each house
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // if he loot the ith house then he can't loot i-1 so then the profit will be
            // dp[i-2]+nums[i]
            // if he don't loot the ith house then profit will be same as dp[i-1]
            // we will decide either he loot the ith house or not by which condition is
            // giving max profit
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];

    }
}