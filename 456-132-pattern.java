class Solution {
    public boolean find132pattern(int[] nums) {
        boolean res = false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (k < n && nums[i] < nums[k] && nums[k] < nums[j]) {
                        res = true;
                        break;
                    }
                }
                if (res == true)
                    break;
            }
            if (res == true)
                break;
        }
        return res;
    }
}