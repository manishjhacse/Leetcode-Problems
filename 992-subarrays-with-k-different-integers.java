class Solution {
    public int subarraysWithMaxKDistinct(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        while (end < nums.length) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (map.size() > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithMaxKDistinct(nums, k) - subarraysWithMaxKDistinct(nums, k - 1);
    }
}