class Solution {
    public int[] sortedSquares(int[] nums) {
        int result[] = new int[nums.length];
        int n0 = nums[0];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        if (n0 >= 0)
            return nums;
        int tail = 0, head = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[head] > nums[tail]) {
                result[i] = nums[head];
                head--;
            } else {
                result[i] = nums[tail];
                tail++;
            }
        }
        return result;
    }
}