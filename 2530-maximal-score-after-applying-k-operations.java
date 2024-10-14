class Solution {
    public long maxKelements(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < len; i++) {
            p.offer(nums[i]);
        }
        long sum = 0;
        for(int i = 1; i <= k; i++) {
            int max = p.poll();
            sum += (long)max;
            double num =Math.ceil(max/3d);
            max = (int)num;
            p.offer(max);
        }
        return sum;
    }
}