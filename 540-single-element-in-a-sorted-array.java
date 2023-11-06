class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        int l = 0, h = nums.length - 1;
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                ans = nums[mid];
                break;
            }
            if ((mid % 2 != 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 0 && nums[mid] == nums[mid - 1])) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return ans;
    }
}