class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> map = new HashSet();
        int max = -1;
        for (int num : nums) {
            if (Math.abs(num) <= max)
                continue;
            if (map.contains(-num)) {
                max = Math.abs(num);
            } else {
                map.add(num);
            }

        }

        return max;
    }
}