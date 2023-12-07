class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        if(nums.length < 3) return 0;

        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num - diff) && set.contains(num - diff*2)) {
                count++;
            }
            set.add(num);
        }
        return count;
    }
}