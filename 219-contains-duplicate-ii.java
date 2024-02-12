class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;

        Set<Integer> slidingWindow = new HashSet<>();
        for (int index = 0; index < nums.length; index++) {
            if (slidingWindow.contains(nums[index]))
                return true;
            if (index >= k)
                slidingWindow.remove(nums[index - k]);
            slidingWindow.add(nums[index]);
        }
        return false;
    }
}