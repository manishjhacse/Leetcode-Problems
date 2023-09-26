class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        int Index = -1;
        if (nums[0] > target) {
            Index = 0;
            return Index;
        } else if (nums[nums.length - 1] < target) {
            Index = nums.length;
            return Index;
        }
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                Index = mid;
                break;
            } else if (mid < nums.length && nums[mid] < target && nums[mid + 1] > target) {
                Index = mid + 1;
                break;
            } else if (mid > 0 && nums[mid - 1] < target && nums[mid] > target) {
                Index = mid;
                break;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return Index;
    }
}