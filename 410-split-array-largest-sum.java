class Solution {
    public int findSubarray(int nums[], int sum) {
        int noOfSubarray = 1, subSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (subSum + nums[i] <= sum) {
                subSum += nums[i];
            } else {
                noOfSubarray++;
                subSum = nums[i];
            }
        }
        return noOfSubarray;
    }

    public int splitArray(int[] nums, int k) {
        int min = nums[0], max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                min = nums[i];
            }
            max += nums[i];
        }
        // for(int i=min;i<=max;i++){
        // int numOfSubarray=findSubarray(nums,i);
        // if(numOfSubarray==k)
        // return i;
        // }
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int noOfSubarray = findSubarray(nums, mid);
            if (noOfSubarray > k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }
}