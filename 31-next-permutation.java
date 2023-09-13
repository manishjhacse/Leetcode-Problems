class Solution {
    public void nextPermutation(int[] nums) {
        int pIndex = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pIndex = i;
                break;
            }
        }
        if (pIndex == -1) {
            // edge case if there is no permutation is greater we have to resturn the
            // smallest permutation for whch we just need to reverse the array
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start++;
                end--;
            }
        } else {
            // we will now store the value which is greater than nums[pindex] but smallest
            // than other.
            for (int i = nums.length - 1; i >= pIndex; i--) {
                if (nums[i] > nums[pIndex]) {
                    int temp = nums[i];
                    nums[i] = nums[pIndex];
                    nums[pIndex] = temp;
                    break;
                }
            }
            // now we will reverse the remaining array
            int start = pIndex + 1;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start++;
                end--;
            }

        }

    }
}