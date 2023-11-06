class Solution {
    public static boolean isDivisor(int nums[], int k, int threshold) {
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + Math.ceil((double)nums[i] / (double)k);
        }
        if (sum <= threshold)
            return true;
        else
            return false;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int min =1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (isDivisor(nums, mid, threshold)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}