class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean res = true;
        if (nums[0] > nums[nums.length - 1]) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    res = false;
                    break;
                }
            }
        }

        else {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
}